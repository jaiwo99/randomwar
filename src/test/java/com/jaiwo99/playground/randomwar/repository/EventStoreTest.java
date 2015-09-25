package com.jaiwo99.playground.randomwar.repository;

import com.jaiwo99.playground.randomwar.RandomWar;
import com.jaiwo99.playground.randomwar.domain.Warrior;
import com.jaiwo99.playground.randomwar.event.*;
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

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class EventStoreTest {

    Warrior warrior;
    EventStore eventStore;
    File eventFile;

    @Rule
    public TemporaryFolder testFolder = new TemporaryFolder();

    @Before
    public void setUp() throws IOException {
        eventStore = EventStore.getInstance();
        warrior = new Warrior("id", "name");
        RandomWar.getInstance().currentWarrior = warrior;
        eventStore.storePath = testFolder.getRoot().getPath();
        eventFile = testFolder.newFile(warrior.id);
        Files.write(eventFile.toPath(), Arrays.asList("EXPLORE;1;1"), StandardOpenOption.APPEND);
        Files.write(eventFile.toPath(), Arrays.asList("FIGHT"), StandardOpenOption.APPEND);
        Files.write(eventFile.toPath(), Arrays.asList("WIN_FIGHT"), StandardOpenOption.APPEND);
        Files.write(eventFile.toPath(), Arrays.asList("LOSE_FIGHT"), StandardOpenOption.APPEND);
        Files.write(eventFile.toPath(), Arrays.asList("NONE"), StandardOpenOption.APPEND);
        Files.write(eventFile.toPath(), Arrays.asList("HEAL"), StandardOpenOption.APPEND);
        Files.write(eventFile.toPath(), Arrays.asList("GAME_OVER"), StandardOpenOption.APPEND);
    }

    @Test
    public void saveEvent_should_save_event_to_store() throws IOException {
        List<String> allLines = Files.readAllLines(eventFile.toPath());
        assertThat(allLines.size(), is(7));
        eventStore.saveEvent(new NoneEvent());

        allLines = Files.readAllLines(eventFile.toPath());

        assertThat(allLines.size(), is(8));
        assertTrue(allLines.stream().anyMatch(l -> "NONE".equals(l)));
    }

    @Test
    public void loadEvents_should_load_all_events() {
        List<Event> events = eventStore.loadEvents();
        assertThat(events.size(), is(7));
        assertThat(events.get(0), instanceOf(ExploreEvent.class));
        assertThat(events.get(1), instanceOf(FightEvent.class));
        assertThat(events.get(2), instanceOf(WinFightEvent.class));
        assertThat(events.get(3), instanceOf(LoseFightEvent.class));
        assertThat(events.get(4), instanceOf(NoneEvent.class));
        assertThat(events.get(5), instanceOf(HealEvent.class));
        assertThat(events.get(6), instanceOf(GameOverEvent.class));
    }
}