package com.jaiwo99.playground.randomwar.event;

import com.jaiwo99.playground.randomwar.domain.Warrior;
import com.jaiwo99.playground.randomwar.system.Consumable;

/**
 * @author jaiwo99
 */
public class LoseFightEvent implements Event, Consumable {

    @Override
    public void consume(Warrior warrior) {
        warrior.score--;
        System.out.println("Warrior lose the fight, lose one health point");
    }

    @Override
    public EventType getEventType() {
        return EventType.LOSE_FIGHT;
    }
}
