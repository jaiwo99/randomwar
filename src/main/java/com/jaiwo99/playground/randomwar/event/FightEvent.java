package com.jaiwo99.playground.randomwar.event;

/**
 * @author jaiwo99
 */
public class FightEvent implements Event {

    @Override
    public void consume() {
        System.out.println("Warrior is going to fight");
    }

    @Override
    public EventType getEventType() {
        return EventType.FIGHT;
    }


    @Override
    public String toDataString() {
        return getEventType().name();
    }

    public static FightEvent fromString(String data) {
        return new FightEvent();
    }
}
