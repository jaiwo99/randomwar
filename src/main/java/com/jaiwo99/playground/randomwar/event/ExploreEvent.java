package com.jaiwo99.playground.randomwar.event;

import com.jaiwo99.playground.randomwar.domain.Warrior;
import com.jaiwo99.playground.randomwar.system.Consumable;
import com.jaiwo99.playground.randomwar.system.Position;

/**
 * @author liang shi
 * @since 24.09.15
 */
public class ExploreEvent implements Event, Consumable {

    private final Position position;

    public ExploreEvent(Position position) {
        this.position = position;
    }

    @Override
    public EventType getEventType() {
        return EventType.EXPLORE;
    }

    @Override
    public void consume(Warrior warrior) {
        warrior.position = position;
        System.out.println("Warrior moved to " + position);
    }
}
