package com.jaiwo99.playground.randomwar.menu;

import org.junit.Test;

import static com.jaiwo99.playground.randomwar.menu.MenuActionFactory.*;
import static com.jaiwo99.playground.randomwar.menu.MenuActionType.*;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

public class MenuActionFactoryTest {

    @Test
    public void expect_create_new_warrior_action() {
        assertThat(getInstance().getMenuActionByType(CREATE_NEW_WARRIOR), instanceOf(CreateWarriorMenuAction.class));
    }

    @Test
    public void expect_explore_action() {
        assertThat(getInstance().getMenuActionByType(EXPLORE), instanceOf(WarriorExploreMenuAction.class));
    }

    @Test
    public void expect_win_a_fight_action() {
        assertThat(getInstance().getMenuActionByType(WIN_A_FIGHT), instanceOf(WinFightMenuAction.class));
    }

    @Test
    public void expect_lose_a_fight_action() {
        assertThat(getInstance().getMenuActionByType(LOSE_A_FIGHT), instanceOf(LoseFightMenuAction.class));
    }

    @Test
    public void expect_heal_action() {
        assertThat(getInstance().getMenuActionByType(HEALED), instanceOf(WarriorHealedAction.class));
    }

    @Test
    public void expect_start_game_action() {
        assertThat(getInstance().getMenuActionByType(START_GAME), instanceOf(StartGameAction.class));
    }

    @Test
    public void expect_game_over_action() {
        assertThat(getInstance().getMenuActionByType(GAME_OVER), instanceOf(WarriorGameOverAction.class));
    }

    @Test
    public void expect_none_action() {
        assertThat(getInstance().getMenuActionByType(SAVE), instanceOf(NoneMenuAction.class));
        assertThat(getInstance().getMenuActionByType(QUIT_GAME), instanceOf(NoneMenuAction.class));
        assertThat(getInstance().getMenuActionByType(NONE), instanceOf(NoneMenuAction.class));
        assertThat(getInstance().getMenuActionByType(BACK_TO_MAIN_MENU), instanceOf(NoneMenuAction.class));
    }
}