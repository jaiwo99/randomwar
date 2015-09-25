package com.jaiwo99.playground.randomwar.menu;

import com.jaiwo99.playground.randomwar.system.FightResult;
import com.jaiwo99.playground.randomwar.system.RockPaperScissorsJudge;

import java.util.Scanner;

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
            FightResult fightResult;
            System.out.println("\nRock Paper Scissors?");
            System.out.println("(1) Rock");
            System.out.println("(2) Paper");
            System.out.println("(3) Scissors");

            String input = scanner.nextLine();

            final String computerChoice = RockPaperScissorsJudge.randomComputerMove();

            if ("1".equals(input)) {
                fightResult = RockPaperScissorsJudge.rockPaperScissors("Rock", computerChoice);
            } else if ("2".equals(input)) {
                fightResult = RockPaperScissorsJudge.rockPaperScissors("Paper", computerChoice);
            } else if ("3".equals(input)) {
                fightResult = RockPaperScissorsJudge.rockPaperScissors("Scissors", computerChoice);
            } else {
                System.out.println("Invalid input, please retry");
                continue;
            }

            if (fightResult == FightResult.LOSE) {
                type = MenuActionType.LOSE_A_FIGHT;
                break;
            } else if (fightResult == FightResult.WIN) {
                type = MenuActionType.WIN_A_FIGHT;
                break;
            } else {
                System.out.println("Played a tie, rematch");
            }
        }

        MenuActionFactory.getInstance().getMenuActionByType(type).execute();
        MenuEndpointFactory.getInstance().getMenuEndpointByType(type).show();
    }
}
