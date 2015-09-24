package com.jaiwo99.playground.randomwar.event;

import com.jaiwo99.playground.randomwar.domain.Warrior;
import com.jaiwo99.playground.randomwar.system.Consumable;

/**
 * @author jaiwo99
 */
public class HealEvent implements Event, Consumable {
    @Override
    public void consume(Warrior warrior) {
        warrior.health++;
        System.out.println("Warrior got one more health point");
    }

    @Override
    public EventType getEventType() {
        return EventType.HEAL;
    }
}
