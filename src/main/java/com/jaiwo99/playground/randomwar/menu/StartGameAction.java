package com.jaiwo99.playground.randomwar.menu;

import com.jaiwo99.playground.randomwar.domain.Warrior;

/**
 * @author jaiwo99
 */
public class StartGameAction implements MenuAction {

    private final Warrior warrior;

    public StartGameAction(Warrior warrior) {
        this.warrior = warrior;
    }

    @Override
    public void execute() {

    }
}
