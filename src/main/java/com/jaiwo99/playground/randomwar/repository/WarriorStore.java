package com.jaiwo99.playground.randomwar.repository;

import com.jaiwo99.playground.randomwar.constant.DataStoreConstant;
import com.jaiwo99.playground.randomwar.domain.Warrior;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jaiwo99
 */
public class WarriorStore {

    private static final WarriorStore warriorStore = new WarriorStore();

    private WarriorStore() {
    }

    public String storePath;

    public static WarriorStore getInstance() {
        return warriorStore;
    }

    public List<Warrior> load() {
        final List<Warrior> warriors = new ArrayList<>();
        Path warriorFile = Paths.get(storePath, DataStoreConstant.WARRIOR_STORE_PATH);
        try {
            Files.lines(warriorFile).forEach(s -> {
                final String[] data = s.split(";");
                warriors.add(new Warrior(data[0], data[1]));
            });
        } catch (IOException e) {
            System.out.println("Failed to load warriors, reason " + e.getMessage());
        }
        return warriors;
    }

    public String saveWarrior(Warrior warrior) {
        try {
            Files.write(Paths.get(storePath, DataStoreConstant.WARRIOR_STORE_PATH), Arrays.asList(warrior.toRecordString()), StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println("Failed to save warrior, reason " + e);
        }
        return warrior.id;
    }
}
