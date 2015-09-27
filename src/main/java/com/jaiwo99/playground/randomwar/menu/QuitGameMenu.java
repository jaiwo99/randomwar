package com.jaiwo99.playground.randomwar.menu;

/**
 * @author liang shi
 */
public class QuitGameMenu implements Menu {

    @Override
    public void show() {
        System.out.println("Bye~~");
        System.exit(0);
    }
}
