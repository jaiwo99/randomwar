package com.jaiwo99.playground.randomwar.repository;

import com.jaiwo99.playground.randomwar.RandomWar;
import com.jaiwo99.playground.randomwar.event.Event;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jaiwo99
 */
public class EventStore {

    private static final EventStore eventStore = new EventStore();

    public String storePath;

    private EventStore() {
    }

    public static EventStore getInstance() {
        return eventStore;
    }

    public void saveEvent(Event event) {
        try {
            Files.write(Paths.get(storePath, RandomWar.getInstance().currentWarrior.id), Arrays.asList(event.toDataString()), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println("Failed to save warrior, reason " + e);
        }
    }

    public List<Event> loadEvents() {
        return new ArrayList<>();
    }
}
