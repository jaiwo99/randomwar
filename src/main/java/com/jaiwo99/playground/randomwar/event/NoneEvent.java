package com.jaiwo99.playground.randomwar.event;

import com.jaiwo99.playground.randomwar.domain.Warrior;
import com.jaiwo99.playground.randomwar.system.Consumable;

/**
 * @author jaiwo99
 */
public class NoneEvent implements Event, Consumable {
    @Override
    public void consume(Warrior warrior) {
        System.out.println("Nothing happened");
    }

    @Override
    public EventType getEventType() {
        return EventType.NONE;
    }
}
