package com.jaiwo99.playground.randomwar.menu;

import com.jaiwo99.playground.randomwar.RandomWar;
import com.jaiwo99.playground.randomwar.event.GameOverEvent;
import com.jaiwo99.playground.randomwar.repository.EventStore;

/**
 * @author liang shi
 */
public class WarriorGameOverAction implements MenuAction {

    private final EventStore eventStore;

    public WarriorGameOverAction(EventStore eventStore) {
        this.eventStore = eventStore;
    }

    @Override
    public void execute() {
        final GameOverEvent event = new GameOverEvent();
        RandomWar.getInstance().currentWarrior.consume(event);
        eventStore.saveEvent(event);
    }
}
