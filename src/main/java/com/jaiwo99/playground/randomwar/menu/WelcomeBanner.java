package com.jaiwo99.playground.randomwar.menu;

/**
 * @author jaiwo99
 */
public class WelcomeBanner implements Menu {

    @Override
    public void show() {
        System.out.println("\n#########################################");
        System.out.println("# Welcome to RandomWar");
        System.out.println("#########################################\n");
    }
}
