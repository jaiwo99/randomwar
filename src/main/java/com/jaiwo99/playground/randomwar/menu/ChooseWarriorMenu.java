package com.jaiwo99.playground.randomwar.menu;

import com.jaiwo99.playground.randomwar.RandomWar;
import com.jaiwo99.playground.randomwar.domain.Warrior;

import java.util.List;
import java.util.Scanner;

/**
 * @author jaiwo99
 */
public class ChooseWarriorMenu implements Menu {

    private final List<Warrior> warriors;

    public ChooseWarriorMenu(List<Warrior> warriors) {
        this.warriors = warriors;
    }

    @Override
    public void show() {
        final Scanner scanner = new Scanner(System.in);

        System.out.println("\nPlease choose one warrior to start game:");
        for (int i = 0; i <warriors.size(); i++) {
            System.out.println(String.format("(%s) %s", i+1, warriors.get(i).name));
        }
        System.out.println("(b) Back to upper menu");

        MenuActionType type;
        while (true) {
            String input = scanner.nextLine();
            boolean validInput = false;
            for (int i = 0; i <warriors.size(); i++) {
                if (String.valueOf(i+1).equals(input)) {
                    RandomWar.getInstance().currentWarrior = warriors.get(i);
                    validInput = true;
                    break;
                }
            }

            if (validInput) {
                type = MenuActionType.START_GAME;
                break;
            } else if ("b".equals(input)) {
                type = MenuActionType.BACK_TO_MAIN_MENU;
                break;
            } else {
                System.out.println("Invalid input, please try again");
            }
        }

        MenuActionFactory.getInstance().getMenuActionByType(type).execute();
        MenuEndpointFactory.getInstance().getMenuEndpointByType(type).show();
    }
}
