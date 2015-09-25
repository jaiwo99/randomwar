package com.jaiwo99.playground.randomwar.menu;

import java.util.Scanner;

import static java.util.concurrent.ThreadLocalRandom.current;

/**
 * @author jaiwo99
 */
public class WarriorFightMenu implements Menu {

    @Override
    public void show() {
        System.out.println("Warrior met a monster");

        Scanner scanner = new Scanner(System.in);

        MenuActionType type;
        while (true) {
            GameOutcome gameOutcome;
            System.out.println("Choose one:");
            System.out.println("(1) Rock");
            System.out.println("(2) Paper");
            System.out.println("(3) Scissor");

            String input = scanner.nextLine();

            if ("1".equals(input) || "2".equals(input) || "3".equals(input)) {
                gameOutcome = fight(input);
                if (gameOutcome == GameOutcome.LOSE) {
                    type = MenuActionType.LOSE_A_FIGHT;
                    System.out.println("Warrior lost the fight");
                    break;
                } else if (gameOutcome == GameOutcome.WIN) {
                    type = MenuActionType.WIN_A_FIGHT;
                    System.out.println("Warrior won the fight");
                    break;
                } else {
                    System.out.println("Played a tie, rematch");
                }
            } else {
                System.out.println("Invalid input, please retry");
            }
        }

        MenuActionFactory.getInstance().getMenuActionByType(type).execute();
        MenuEndpointFactory.getInstance().getMenuEndpointByType(type).show();
    }

    private GameOutcome fight(String input) {
        String userChoice;
        if ("1".equals(input)) {
            userChoice = "Rock";
        } else if ("2".equals(input)) {
            userChoice = "Paper";
        } else {
            userChoice = "Scissor";
        }

        final String computerChoice = randomComputerMove();

        System.out.println(String.format("Warrior chose %s, computer chose %s", userChoice, computerChoice));

        if (userChoice.equalsIgnoreCase(computerChoice)) {

            return GameOutcome.TIE;

        } else if(userChoice.equalsIgnoreCase("ROCK")){

            if(computerChoice.equalsIgnoreCase("PAPER")){
                return GameOutcome.LOSE;
            } else {
                return GameOutcome.WIN;
            }

        } else if(userChoice.equalsIgnoreCase("PAPER")){

            if(computerChoice.equalsIgnoreCase("SCISSORS")){
                return GameOutcome.LOSE;
            } else {
                return GameOutcome.WIN;
            }

        } else {

            if(computerChoice.equalsIgnoreCase("ROCK")){
                return GameOutcome.LOSE;
            } else {
                return GameOutcome.WIN;
            }
        }
    }

    private String randomComputerMove() {
        String[] moves = new String[] {"Rock", "Paper", "Scissor"};
        return moves[current().nextInt(moves.length)];
    }

    private static enum GameOutcome {
        WIN, LOSE, TIE
    }
}
