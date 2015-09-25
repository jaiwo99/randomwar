package com.jaiwo99.playground.randomwar.domain;

import com.jaiwo99.playground.randomwar.constant.WarriorConstant;
import com.jaiwo99.playground.randomwar.system.Consumable;
import com.jaiwo99.playground.randomwar.system.Position;

/**
 * @author liang shi
 * @since 24.09.15
 */
public class Warrior {

    public final String id;
    public final String name;
    public int health;
    public Position position;
    public int score;

    public Warrior(String id, String name) {
        this.id = id;
        this.name = name;
        health = WarriorConstant.WARRIOR_INIT_HEALTH;
        score = WarriorConstant.WARRIOR_INIT_SCORE;
        position = new Position(WarriorConstant.WARRIOR_INIT_X, WarriorConstant.WARRIOR_INIT_Y);
    }

    public void consume(Consumable event) {
        event.consume(this);
    }
}
