package com.jaiwo99.playground.randomwar.menu;

import java.util.Scanner;

/**
 * @author jaiwo99
 */
public class GameMenu implements Menu {

    @Override
    public void show() {
        Scanner scanner = new Scanner(System.in);


        MenuActionType type;
        while (true) {
            System.out.println("\nPlease choose an action:");
            System.out.println("(1) explore");
            System.out.println("(s) save game and exit");
            String input = scanner.nextLine();
            if ("1".equals(input)) {
                type = MenuActionType.EXPLORE;
                break;
            } else if ("s".equals(input)) {
                type = MenuActionType.SAVE;
                break;
            } else {
                System.out.println("Invalid input, try again!");
            }
        }

        MenuActionFactory.getInstance().getMenuActionByType(type).execute();
        MenuEndpointFactory.getInstance().getMenuEndpointByType(type).show();
    }
}
