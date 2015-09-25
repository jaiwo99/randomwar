package com.jaiwo99.playground.randomwar.repository;

import com.jaiwo99.playground.randomwar.RandomWar;
import com.jaiwo99.playground.randomwar.constant.DataStoreConstant;
import com.jaiwo99.playground.randomwar.domain.Warrior;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class WarriorStoreTest {
    Warrior warrior;
    WarriorStore warriorStore;
    File warriorFile;

    @Rule
    public TemporaryFolder testFolder = new TemporaryFolder();

    @Before
    public void setUp() throws IOException {
        warriorStore = WarriorStore.getInstance();
        warrior = new Warrior("id", "name");
        RandomWar.getInstance().currentWarrior = warrior;
        warriorStore.storePath = testFolder.getRoot().getPath();
        warriorFile = testFolder.newFile(DataStoreConstant.WARRIOR_STORE_PATH.substring(1));
        Files.write(warriorFile.toPath(), Arrays.asList("id;name"), StandardOpenOption.APPEND);
        Files.write(warriorFile.toPath(), Arrays.asList("id2;name2"), StandardOpenOption.APPEND);
        Files.write(warriorFile.toPath(), Arrays.asList("id3;name3"), StandardOpenOption.APPEND);
    }

    @Test
    public void load_should_load_all_warriors() {
        List<Warrior> warriorList = warriorStore.load();

        assertThat(warriorList.size(), is(3));
        assertThat(warriorList.get(0).id, is("id"));
        assertThat(warriorList.get(0).name, is("name"));
        assertThat(warriorList.get(1).id, is("id2"));
        assertThat(warriorList.get(1).name, is("name2"));
        assertThat(warriorList.get(2).id, is("id3"));
        assertThat(warriorList.get(2).name, is("name3"));
    }

    @Test
    public void saveWarrior_should_save_warrior() {
        warriorStore.saveWarrior(new Warrior("id4", "name4"));

        List<Warrior> warriorList = warriorStore.load();
        assertThat(warriorList.size(), is(4));
        assertThat(warriorList.get(3).id, is("id4"));
        assertThat(warriorList.get(3).name, is("name4"));
    }
}