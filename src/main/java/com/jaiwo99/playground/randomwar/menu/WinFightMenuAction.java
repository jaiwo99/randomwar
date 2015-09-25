package com.jaiwo99.playground.randomwar.menu;

import com.jaiwo99.playground.randomwar.repository.EventStore;

/**
 * @author jaiwo99
 */
public class WinFightMenuAction implements MenuAction {
    private final EventStore eventStore;

    public WinFightMenuAction(EventStore eventStore) {
        this.eventStore = eventStore;
    }

    @Override
    public void execute() {

    }
}
