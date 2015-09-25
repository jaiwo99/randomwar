package com.jaiwo99.playground.randomwar;

import com.jaiwo99.playground.randomwar.constant.DataStoreConstant;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class GameTest {

    @Rule
    public TemporaryFolder testFolder = new TemporaryFolder();

    @Test
    public void buildDataStore_should_create_dataStore_structure() throws IOException {
        File root = testFolder.newFolder();
        Game.buildDataStore(root.getPath());

        assertTrue(new File(root.getPath() + DataStoreConstant.WARRIOR_STORE_PATH).exists());
    }

    @Test
    public void buildDataStore_should_create_root_folder() throws IOException {
        String randomRoot = testFolder.getRoot().getPath() + "/whatever";
        Game.buildDataStore(randomRoot);

        assertTrue(new File(randomRoot).exists());
        assertTrue(new File(randomRoot + DataStoreConstant.WARRIOR_STORE_PATH).exists());
    }
}