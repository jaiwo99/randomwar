package com.jaiwo99.playground.randomwar.repository;

import com.jaiwo99.playground.randomwar.RandomWar;
import com.jaiwo99.playground.randomwar.event.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.jaiwo99.playground.randomwar.event.EventType.valueOf;

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
        final List<Event> events = new ArrayList<>();
        Path eventFile = Paths.get(storePath, RandomWar.getInstance().currentWarrior.id);
        try {
            Files.lines(eventFile).forEachOrdered(s -> {
                events.add(buildEvent(s));
            });
        } catch (IOException e) {
            System.out.println("Failed to load warriors, reason " + e.getMessage());
        }
        return events;
    }

    private Event buildEvent(String s) {
        switch (valueOf(s.split(";")[0])) {
            case EXPLORE:
                return ExploreEvent.fromString(s);
            case FIGHT:
                return FightEvent.fromString(s);
            case GAME_OVER:
                return GameOverEvent.fromString(s);
            case HEAL:
                return HealEvent.fromString(s);
            case LOSE_FIGHT:
                return LoseFightEvent.fromString(s);
            case NONE:
                return NoneEvent.fromString(s);
            case WIN_FIGHT:
                return WinFightEvent.fromString(s);
            default:
                throw new UnsupportedOperationException(String.format("Event Type %s is not supported yet!"));
        }
    }
}
