package com.jaiwo99.playground.randomwar.domain;

import com.jaiwo99.playground.randomwar.system.Consumable;
import com.jaiwo99.playground.randomwar.system.Position;

/**
 * @author liang shi
 * @since 24.09.15
 */
public class Warrior {

    public final String name;
    public int health;
    public Position position;
    public int score;

    public Warrior(String name) {
        this.name = name;
    }

    public void consume(Consumable event) {
        event.consume(this);
    }
}
