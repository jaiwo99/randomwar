package com.jaiwo99.playground.randomwar.menu;

import com.jaiwo99.playground.randomwar.RandomWar;
import com.jaiwo99.playground.randomwar.repository.EventStore;

/**
 * @author jaiwo99
 */
public class StartGameAction implements MenuAction {

    private final EventStore eventStore;

    public StartGameAction(EventStore eventStore) {
        this.eventStore = eventStore;
    }

    /**
     * Important part of loading a warrior, all the events of the character
     * will be replayed so that the status of the character can be rebuild.
     */
    @Override
    public void execute() {
        eventStore.loadEvents().stream().forEachOrdered(event ->
            RandomWar.getInstance().currentWarrior.consume(event)
        );
    }
}
