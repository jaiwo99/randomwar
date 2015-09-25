package com.jaiwo99.playground.randomwar.system;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RockPaperScissorsJudgeTest {

    @Test
    public void when_user_choose_rock() {
        assertThat(RockPaperScissorsJudge.rockPaperScissors("Rock", "Rock"), is(FightResult.TIE));
        assertThat(RockPaperScissorsJudge.rockPaperScissors("Rock", "Paper"), is(FightResult.LOSE));
        assertThat(RockPaperScissorsJudge.rockPaperScissors("Rock", "Scissors"), is(FightResult.WIN));
    }

    @Test
    public void when_user_choose_paper() {
        assertThat(RockPaperScissorsJudge.rockPaperScissors("Paper", "Rock"), is(FightResult.WIN));
        assertThat(RockPaperScissorsJudge.rockPaperScissors("Paper", "Paper"), is(FightResult.TIE));
        assertThat(RockPaperScissorsJudge.rockPaperScissors("Paper", "Scissors"), is(FightResult.LOSE));
    }

    @Test
    public void when_user_choose_scissors() {
        assertThat(RockPaperScissorsJudge.rockPaperScissors("Scissors", "Rock"), is(FightResult.LOSE));
        assertThat(RockPaperScissorsJudge.rockPaperScissors("Scissors", "Paper"), is(FightResult.WIN));
        assertThat(RockPaperScissorsJudge.rockPaperScissors("Scissors", "Scissors"), is(FightResult.TIE));
    }
}