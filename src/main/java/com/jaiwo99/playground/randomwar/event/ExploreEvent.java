package com.jaiwo99.playground.randomwar.event;

import com.jaiwo99.playground.randomwar.RandomWar;
import com.jaiwo99.playground.randomwar.system.Position;

import static com.jaiwo99.playground.randomwar.constant.DataStoreConstant.DATA_SEPARATOR_SYMBOL;

/**
 * @author liang shi
 */
public class ExploreEvent implements Event {

    public final Position position;

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
        return String.format("%s%s%s%s%s", getEventType(), DATA_SEPARATOR_SYMBOL, position.x, DATA_SEPARATOR_SYMBOL, position.y);
    }

    public static ExploreEvent fromString(String data) {
        final String[] dataArray = data.split(DATA_SEPARATOR_SYMBOL);
        return new ExploreEvent(new Position(Integer.valueOf(dataArray[1]), Integer.valueOf(dataArray[2])));
    }
}
