package com.jaiwo99.playground.randomwar.system;

import com.jaiwo99.playground.randomwar.event.EventType;

import static com.jaiwo99.playground.randomwar.event.EventType.*;
import static java.util.concurrent.ThreadLocalRandom.current;

/**
 * Generates following event for a warrior
 *
 * @author jaiwo99
 */
public class GameEventTypeGenerator {
    private GameEventTypeGenerator() {
    }

    public static EventType generateEventFollowsExplore() {
        EventType[] eventTypes = new EventType[] {FIGHT, FIGHT, FIGHT, FIGHT, FIGHT, HEAL, NONE};
        return eventTypes[current().nextInt(eventTypes.length)];
    }
}
