package com.jaiwo99.playground.randomwar.event;

import com.jaiwo99.playground.randomwar.RandomWar;

/**
 * @author jaiwo99
 */
public class WinFightEvent implements Event {


    @Override
    public void consume() {
        RandomWar.getInstance().currentWarrior.score += 1;
        System.out.println("Warrior win the fight, got one more score");
    }

    @Override
    public EventType getEventType() {
        return EventType.WIN_FIGHT;
    }

    @Override
    public String toDataString() {
        return getEventType().name();
    }
}
