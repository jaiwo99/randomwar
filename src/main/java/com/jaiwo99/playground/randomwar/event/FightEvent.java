package com.jaiwo99.playground.randomwar.event;

import com.jaiwo99.playground.randomwar.domain.Warrior;

/**
 * @author jaiwo99
 */
public class FightEvent implements Event {

    @Override
    public void consume(Warrior warrior) {
        System.out.println("Warrior is going to fight");
    }

    @Override
    public EventType getEventType() {
        return EventType.FIGHT;
    }


}
