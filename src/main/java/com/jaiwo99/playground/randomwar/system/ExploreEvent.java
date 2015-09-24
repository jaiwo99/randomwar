package com.jaiwo99.playground.randomwar.system;

/**
 * @author liang shi
 * @since 24.09.15
 */
public class ExploreEvent implements Event {

    private final Position oldPosition;
    private final Position newPosition;
    private final EventType eventType;

    public ExploreEvent(Position oldPosition, Position newPosition) {
        this.oldPosition = oldPosition;
        this.newPosition = newPosition;
        this.eventType = EventType.EXPLORE;
    }

    public EventType getEventType() {
        return eventType;
    }

    public Position getOldPosition() {
        return oldPosition;
    }

    public Position getNewPosition() {
        return newPosition;
    }
}
