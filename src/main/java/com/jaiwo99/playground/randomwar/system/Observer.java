package com.jaiwo99.playground.randomwar.system;

/**
 * @author liang shi
 * @since 24.09.15
 */
public interface Observer {

    void update(Observable observable, Event event);
}
