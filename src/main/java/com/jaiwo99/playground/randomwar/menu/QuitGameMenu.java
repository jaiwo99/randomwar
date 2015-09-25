package com.jaiwo99.playground.randomwar.menu;

/**
 * @author liang shi
 * @since 25.09.15
 */
public class QuitGameMenu implements Menu {

    @Override
    public void show() {
        System.out.println("Bye~~");
        System.exit(0);
    }
}
