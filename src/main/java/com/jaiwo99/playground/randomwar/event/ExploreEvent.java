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

    @Override
    public String toDataString() {
        return String.format("%s;%s;%s", getEventType(), position.x, position.y);
    }

    public static ExploreEvent fromString(String data) {
        final String[] dataArray = data.split(";");
        return new ExploreEvent(new Position(Integer.valueOf(dataArray[1]), Integer.valueOf(dataArray[2])));
    }
}
