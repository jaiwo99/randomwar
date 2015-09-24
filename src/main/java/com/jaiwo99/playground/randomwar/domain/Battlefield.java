package com.jaiwo99.playground.randomwar.domain;

import com.jaiwo99.playground.randomwar.system.*;

import static java.util.concurrent.ThreadLocalRandom.current;

/**
 * @author liang shi
 * @since 24.09.15
 */
public class Battlefield implements Observer {

    private static final Battlefield battleField = new Battlefield();

    private Battlefield() {
    }

    public static final Battlefield getBattleField() {
        return battleField;
    }

    public void update(Observable observable, Event event) {
        switch (event.getEventType()) {
            case EXPLORE: {
                if (observable instanceof Warrior) {
                    //TODO
                    Warrior warrior = (Warrior) observable;
                }
            }
        }
    }

    public static Event randomEvent(Warrior warrior) {
        EventType eventType = EventType.values()[current().nextInt(0,2)];
        switch (eventType) {
            case EXPLORE:
                return new ExploreEvent(warrior.getPosition(), PositionGenerator.generate());
            default: throw new UnsupportedOperationException(String.format("Event type: %s is not supported yet!", eventType));
        }
    }
}
