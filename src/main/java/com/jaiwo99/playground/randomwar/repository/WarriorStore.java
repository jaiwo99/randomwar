package com.jaiwo99.playground.randomwar.repository;

import com.jaiwo99.playground.randomwar.RandomWar;
import com.jaiwo99.playground.randomwar.domain.Warrior;

import java.util.List;

/**
 * @author jaiwo99
 */
public class WarriorStore {

    private static final WarriorStore warriorStore = new WarriorStore();

    private WarriorStore() {
    }

    public static WarriorStore getInstance() {
        return warriorStore;
    }

    public List<Warrior> load() {
        return RandomWar.getInstance().warriors;
    }

    public String saveWarrior(Warrior warrior) {
        RandomWar.getInstance().warriors.add(warrior);
        return warrior.id;
    }
}
