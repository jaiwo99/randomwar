package com.jaiwo99.playground.randomwar;

import com.jaiwo99.playground.randomwar.constant.DataStoreConstant;

import java.io.File;
import java.io.IOException;

/**
 * @author liang shi
 * @since 24.09.15
 */
public class Game {

    public static void main(String[] args) {
        try {
            String storePath;
            if (System.getProperty("os.name").startsWith("win")) {
                storePath = DataStoreConstant.WIN_STORE_PATH;
            } else {
                storePath = DataStoreConstant.UNIX_STORE_PATH;
            }

            buildDataStore(storePath);

            RandomWar.getInstance().init(storePath);
        } catch (Exception e) {
            System.out.println("Game stop unexpected because of " + e.getMessage());
            System.exit(1);
        }
    }

    static void buildDataStore(String rootPath) throws IOException {
        File root = new File(rootPath);
        if (root.exists() && root.isDirectory()) {
        } else if (root.exists() && !root.isDirectory()) {
            root.delete();
            root.mkdir();
        } else {
            root.mkdir();
        }

        File warriors = new File(rootPath + DataStoreConstant.WARRIOR_STORE_PATH);
        if (!warriors.exists()) {
            warriors.createNewFile();
        }
    }
}
