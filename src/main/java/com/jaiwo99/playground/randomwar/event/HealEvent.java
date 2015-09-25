package com.jaiwo99.playground.randomwar.event;

import com.jaiwo99.playground.randomwar.RandomWar;

/**
 * @author jaiwo99
 */
public class HealEvent implements Event {
    @Override
    public void consume() {
        RandomWar.getInstance().currentWarrior.health += 1;
        System.out.println("Warrior got one more health point");
    }

    @Override
    public EventType getEventType() {
        return EventType.HEAL;
    }
}
