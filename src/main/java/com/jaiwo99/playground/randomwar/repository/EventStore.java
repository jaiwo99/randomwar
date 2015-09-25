package com.jaiwo99.playground.randomwar.repository;

import com.jaiwo99.playground.randomwar.event.Event;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jaiwo99
 */
public class EventStore {

    private static final EventStore eventStore = new EventStore();

    private EventStore() {
    }

    public static EventStore getInstance() {
        return eventStore;
    }

    public void saveEvent(Event event) {

    }

    public List<Event> loadEvents() {
        return new ArrayList<>();
    }
}
