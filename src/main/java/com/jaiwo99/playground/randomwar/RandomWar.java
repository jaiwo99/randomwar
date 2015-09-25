package com.jaiwo99.playground.randomwar;

import com.jaiwo99.playground.randomwar.domain.Warrior;
import com.jaiwo99.playground.randomwar.menu.MainMenu;
import com.jaiwo99.playground.randomwar.repository.EventStore;
import com.jaiwo99.playground.randomwar.repository.WarriorStore;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jaiwo99
 */
public class RandomWar {

    private static final RandomWar instance = new RandomWar();

    public List<Warrior> warriors = new ArrayList<>();
    public Warrior currentWarrior;

    private final WarriorStore warriorStore;
    private final EventStore eventStore;

    public static RandomWar getInstance() {
        return instance;
    }

    private RandomWar() {
        warriorStore = new WarriorStore();
        eventStore = new EventStore();
    }

    public void init() {

        // load all saved warrior
        warriors = warriorStore.load();

        // show menu
        new MainMenu().show();
    }

}
