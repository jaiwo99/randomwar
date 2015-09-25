package com.jaiwo99.playground.randomwar.menu;

import java.util.Scanner;

/**
 * @author jaiwo99
 */
public class MainMenu implements Menu {

    @Override
    public void show() {

        final Scanner scanner = new Scanner(System.in);


        final MenuActionType type;
        while (true) {
            System.out.println("\nPlease choose one option:");
            System.out.println("(1) create a new warrior");
            System.out.println("(2) start game with an existing warrior");
            System.out.println("(3) quit game");
            String input = scanner.nextLine();
            if ("1".equals(input)) {
                type = MenuActionType.CREATE_NEW_WARRIOR;
                break;
            } else if ("2".equals(input)) {
                type = MenuActionType.LOAD_EXISTING_WARRIOR;
                break;
            } else if ("3".equals(input)) {
                type = MenuActionType.QUIT_GAME;
                break;
            } else {
                System.out.println("Invalid input, please try it again");
            }
        }

        MenuActionFactory.getInstance().getMenuActionByType(type).execute();
        MenuEndpointFactory.getInstance().getMenuEndpointByType(type).show();
    }
}
