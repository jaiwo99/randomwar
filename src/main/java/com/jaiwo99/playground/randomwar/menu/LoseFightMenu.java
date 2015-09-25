package com.jaiwo99.playground.randomwar.menu;

import com.jaiwo99.playground.randomwar.RandomWar;

/**
 * @author jaiwo99
 */
public class LoseFightMenu implements Menu {

    @Override
    public void show() {
       if (RandomWar.getInstance().currentWarrior.health > 0) {
           MenuEndpointFactory.getInstance().getMenuEndpointByType(MenuActionType.CONTINUE_GAME).show();
       } else {
           System.out.println("Game over!");
           MenuEndpointFactory.getInstance().getMenuEndpointByType(MenuActionType.GAME_OVER).show();
       }
    }
}
