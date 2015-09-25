package com.jaiwo99.playground.randomwar.event;

import com.jaiwo99.playground.randomwar.domain.Warrior;

/**
 * @author jaiwo99
 */
public class GameOverEvent implements Event {
    @Override
    public void consume(Warrior warrior) {
        System.out.println(String.format("Game over! Warrior %s got %s scores in this game!", warrior.name, warrior.score));
    }

    @Override
    public EventType getEventType() {
        return EventType.GAME_OVER;
    }
}
