package com.jaiwo99.playground.randomwar.menu;

/**
 * @author jaiwo99
 */
public class WarriorHealedMenu implements Menu {
    @Override
    public void show() {
        System.out.println("Warrior get healed");

        MenuActionFactory.getInstance().getMenuActionByType(MenuActionType.HEALED).execute();
        MenuEndpointFactory.getInstance().getMenuEndpointByType(MenuActionType.HEALED).show();
    }
}
