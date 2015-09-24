package com.jaiwo99.playground.randomwar.event;

import com.jaiwo99.playground.randomwar.domain.Warrior;
import com.jaiwo99.playground.randomwar.system.Consumable;

/**
 * @author jaiwo99
 */
public class WinFightEvent implements Event, Consumable {


    @Override
    public void consume(Warrior warrior) {
        warrior.score++;
        System.out.println("Warrior win the fight, got one more score");
    }

    @Override
    public EventType getEventType() {
        return EventType.WIN_FIGHT;
    }
}
