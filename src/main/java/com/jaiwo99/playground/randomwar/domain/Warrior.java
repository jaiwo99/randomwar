package com.jaiwo99.playground.randomwar.domain;

import com.jaiwo99.playground.randomwar.system.Event;
import com.jaiwo99.playground.randomwar.system.Observable;
import com.jaiwo99.playground.randomwar.system.Position;

/**
 * @author liang shi
 * @since 24.09.15
 */
public class Warrior implements Observable {

    private final String name;
    private int health;
    private Position position;

    private int explored;
    private int fought;
    private int healed;

    public Warrior(String name, int health, Position position) {
        this.name = name;
        this.health = health;
        this.position = position;
        System.out.println("Warrior born at "+ position);
    }

    public Warrior(String name, int health, Position position, int explored, int fought, int healed) {
        this.name = name;
        this.health = health;
        this.position = position;
        this.explored = explored;
        this.fought = fought;
        this.healed = healed;
        System.out.println("Warrior born at "+ position);
    }

    public void explore() {
        explored++;
        Event event = Battlefield.getBattleField().randomEvent(this);
        notifyObserver(event);
    }

    public void fight() {
        // do something
        // notifyObserver
    }

    public void heal() {
        // do something
        // notifyObserver
    }

    public void notifyObserver(Event event) {
        Battlefield.getBattleField().update(this, event);
    }

    public int getHealedTimes() {
        return healed;
    }

    public int getFoughtTimes() {
        return fought;
    }

    public int getExploredTimes() {
        return explored;
    }

    public Position getPosition() {
        return position;
    }
}
