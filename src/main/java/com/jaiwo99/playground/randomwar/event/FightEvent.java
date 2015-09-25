package com.jaiwo99.playground.randomwar.event;

/**
 * @author jaiwo99
 */
public class FightEvent implements Event {

    @Override
    public EventType getEventType() {
        return EventType.FIGHT;
    }
}
