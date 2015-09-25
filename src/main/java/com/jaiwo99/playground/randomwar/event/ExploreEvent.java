package com.jaiwo99.playground.randomwar.event;

import com.jaiwo99.playground.randomwar.RandomWar;
import com.jaiwo99.playground.randomwar.system.Position;

/**
 * @author liang shi
 * @since 24.09.15
 */
public class ExploreEvent implements Event {

    private final Position position;

    public ExploreEvent(Position position) {
        this.position = position;
    }

    @Override
    public EventType getEventType() {
        return EventType.EXPLORE;
    }

    @Override
    public void consume() {
        RandomWar.getInstance().currentWarrior.position = position;
        System.out.println("Warrior moved to " + position);
    }
}
