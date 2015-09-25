package com.jaiwo99.playground.randomwar.event;

import com.jaiwo99.playground.randomwar.RandomWar;
import com.jaiwo99.playground.randomwar.constant.WarriorConstant;
import com.jaiwo99.playground.randomwar.system.Position;

/**
 * @author jaiwo99
 */
public class GameOverEvent implements Event {

    @Override
    public void consume() {
        System.out.println(String.format("Warrior %s got %s scores in this game!", RandomWar.getInstance().currentWarrior.name, RandomWar.getInstance().currentWarrior.score));
        RandomWar.getInstance().currentWarrior.score = WarriorConstant.WARRIOR_INIT_SCORE;
        RandomWar.getInstance().currentWarrior.health = WarriorConstant.WARRIOR_INIT_HEALTH;
        RandomWar.getInstance().currentWarrior.position = new Position(WarriorConstant.WARRIOR_INIT_X, WarriorConstant.WARRIOR_INIT_Y);
    }

    @Override
    public EventType getEventType() {
        return EventType.GAME_OVER;
    }

    @Override
    public String toDataString() {
        return getEventType().name();
    }
}
