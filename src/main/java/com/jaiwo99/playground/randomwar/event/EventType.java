package com.jaiwo99.playground.randomwar.event;

/**
 * @author liang shi
 * @since 24.09.15
 */
public enum EventType {
    EXPLORE, FIGHT, WIN_FIGHT, LOSE_FIGHT, HEAL, NONE, GAME_OVER;


    /**
     * Event types which can be triggered after explore event
     */
    public static EventType[] exploreFollowingEvents() {
        return new EventType[] {FIGHT, HEAL, NONE};
    }

    /**
     * Event types which can be triggered after fight event
     */
    public static EventType[] fightFollowingEvents() {
        return new EventType[] {WIN_FIGHT, LOSE_FIGHT};
    }

    /**
     * Event types which can be triggered after fight lose event
     */
    public static EventType[] loseFightFollowingEvents() {
        return new EventType[] {NONE, GAME_OVER};
    }
}
