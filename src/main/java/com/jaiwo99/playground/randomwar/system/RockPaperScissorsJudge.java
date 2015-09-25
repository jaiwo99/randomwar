package com.jaiwo99.playground.randomwar.system;

import static java.util.concurrent.ThreadLocalRandom.current;

/**
 * @author liang shi
 * @since 25.09.15
 */
public class RockPaperScissorsJudge {

    private RockPaperScissorsJudge() {
    }

    public static FightResult rockPaperScissors(String input) {
        final String computerChoice = randomComputerMove();

        System.out.println(String.format("Warrior chose %s, computer chose %s", input, computerChoice));

        if (input.equalsIgnoreCase(computerChoice)) {

            return FightResult.TIE;

        } else if(input.equalsIgnoreCase("Rock")){

            if(computerChoice.equalsIgnoreCase("Paper")){
                return FightResult.LOSE;
            } else {
                return FightResult.WIN;
            }

        } else if(input.equalsIgnoreCase("Paper")){

            if(computerChoice.equalsIgnoreCase("Scissors")){
                return FightResult.LOSE;
            } else {
                return FightResult.WIN;
            }

        } else {

            if(computerChoice.equalsIgnoreCase("Rock")){
                return FightResult.LOSE;
            } else {
                return FightResult.WIN;
            }
        }
    }

    private static String randomComputerMove() {
        String[] moves = new String[] {"Rock", "Paper", "Scissors"};
        return moves[current().nextInt(moves.length)];
    }
}