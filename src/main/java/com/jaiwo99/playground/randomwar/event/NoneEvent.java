package com.jaiwo99.playground.randomwar.event;

/**
 * @author jaiwo99
 */
public class NoneEvent implements Event {
    @Override
    public void consume() {
        System.out.println("Nothing happened");
    }

    @Override
    public EventType getEventType() {
        return EventType.NONE;
    }

    @Override
    public String toDataString() {
        return getEventType().name();
    }
}
