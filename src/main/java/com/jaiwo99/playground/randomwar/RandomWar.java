package com.jaiwo99.playground.randomwar;

import com.jaiwo99.playground.randomwar.domain.Warrior;
import com.jaiwo99.playground.randomwar.menu.MainMenu;
import com.jaiwo99.playground.randomwar.menu.WelcomeBanner;
import com.jaiwo99.playground.randomwar.repository.EventStore;
import com.jaiwo99.playground.randomwar.repository.WarriorStore;

import java.io.IOException;
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
        warriorStore = WarriorStore.getInstance();
        eventStore = EventStore.getInstance();
    }

    /**
     * Get the game stared by
     * * Set data store path
     * * load warriors from data store
     * * show menu
     */
    public void init(String storePath) throws IOException {
        warriorStore.storePath = storePath;
        eventStore.storePath = storePath;
        // load all saved warrior
        warriors = warriorStore.load();

        new WelcomeBanner().show();

        // show menu
        new MainMenu().show();
    }

}
