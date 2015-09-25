package com.jaiwo99.playground.randomwar.menu;


import org.junit.Test;

import static com.jaiwo99.playground.randomwar.menu.MenuActionType.*;
import static com.jaiwo99.playground.randomwar.menu.MenuEndpointFactory.*;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

public class MenuEndpointFactoryTest {

    @Test
    public void expect_main_menu() {
        assertThat(getInstance().getMenuEndpointByType(BACK_TO_MAIN_MENU), instanceOf(MainMenu.class));
        assertThat(getInstance().getMenuEndpointByType(GAME_OVER), instanceOf(MainMenu.class));
        assertThat(getInstance().getMenuEndpointByType(SAVE), instanceOf(MainMenu.class));
        assertThat(getInstance().getMenuEndpointByType(CREATE_NEW_WARRIOR), instanceOf(MainMenu.class));
    }

    @Test
    public void expect_choose_warrior_menu() {
        assertThat(getInstance().getMenuEndpointByType(LOAD_EXISTING_WARRIOR), instanceOf(ChooseWarriorMenu.class));
    }

    @Test
    public void expect_lose_fight_menu() {
        assertThat(getInstance().getMenuEndpointByType(LOSE_A_FIGHT), instanceOf(LoseFightMenu.class));
    }

    @Test
    public void expect_quit_game_menu() {
        assertThat(getInstance().getMenuEndpointByType(QUIT_GAME), instanceOf(QuitGameMenu.class));
    }

    @Test
    public void expect_game_menu() {
        assertThat(getInstance().getMenuEndpointByType(START_GAME), instanceOf(GameMenu.class));
        assertThat(getInstance().getMenuEndpointByType(CONTINUE_GAME), instanceOf(GameMenu.class));
        assertThat(getInstance().getMenuEndpointByType(WIN_A_FIGHT), instanceOf(GameMenu.class));
        assertThat(getInstance().getMenuEndpointByType(NONE), instanceOf(GameMenu.class));
        assertThat(getInstance().getMenuEndpointByType(HEALED), instanceOf(GameMenu.class));
    }

}