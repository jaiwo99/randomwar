package com.jaiwo99.playground.randomwar.menu;

import com.jaiwo99.playground.randomwar.RandomWar;
import com.jaiwo99.playground.randomwar.event.LoseFightEvent;
import com.jaiwo99.playground.randomwar.repository.EventStore;

/**
 * @author jaiwo99
 */
public class LoseFightMenuAction implements MenuAction {

    private final EventStore eventStore;

    public LoseFightMenuAction(EventStore eventStore) {
        this.eventStore = eventStore;
    }

    @Override
    public void execute() {
        final LoseFightEvent loseFightEvent = new LoseFightEvent();
        RandomWar.getInstance().currentWarrior.consume(loseFightEvent);
        eventStore.saveEvent(loseFightEvent);
    }
}
