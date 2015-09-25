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

    @Override
    public void execute() {
        eventStore.loadEvents().stream().forEachOrdered(event ->
            RandomWar.getInstance().currentWarrior.consume(event)
        );
    }
}
