package com.jaiwo99.playground.randomwar.menu;

import com.jaiwo99.playground.randomwar.RandomWar;
import com.jaiwo99.playground.randomwar.event.HealEvent;
import com.jaiwo99.playground.randomwar.repository.EventStore;

/**
 * @author jaiwo99
 */
public class WarriorHealedAction implements MenuAction {

    private final EventStore eventStore;

    public WarriorHealedAction(EventStore eventStore) {
        this.eventStore = eventStore;
    }

    @Override
    public void execute() {
        final HealEvent healEvent = new HealEvent();
        RandomWar.getInstance().currentWarrior.consume(healEvent);
        eventStore.saveEvent(healEvent);
    }
}
