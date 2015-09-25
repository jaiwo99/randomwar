package com.jaiwo99.playground.randomwar.menu;

import com.jaiwo99.playground.randomwar.RandomWar;
import com.jaiwo99.playground.randomwar.event.ExploreEvent;
import com.jaiwo99.playground.randomwar.repository.EventStore;
import com.jaiwo99.playground.randomwar.system.PositionGenerator;

/**
 * @author jaiwo99
 */
public class WarriorExploreMenuAction implements MenuAction {

    private final EventStore eventStore;

    public WarriorExploreMenuAction(EventStore eventStore) {
        this.eventStore = eventStore;
    }

    @Override
    public void execute() {
        final ExploreEvent exploreEvent = new ExploreEvent(PositionGenerator.generate());
        RandomWar.getInstance().currentWarrior.consume(exploreEvent);
        eventStore.saveEvent(exploreEvent);
    }
}