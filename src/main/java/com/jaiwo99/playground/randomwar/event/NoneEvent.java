package com.jaiwo99.playground.randomwar.event;

import com.jaiwo99.playground.randomwar.domain.Warrior;

/**
 * @author jaiwo99
 */
public class NoneEvent implements Event {
    @Override
    public void consume(Warrior warrior) {
        System.out.println("Nothing happened");
    }

    @Override
    public EventType getEventType() {
        return EventType.NONE;
    }
}
