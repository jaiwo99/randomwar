package com.jaiwo99.playground.randomwar.system;

import com.jaiwo99.playground.randomwar.event.Event;

/**
 * @author liang shi
 * @since 25.09.15
 */
public interface Restoreable {

    Event toEvent(String string);
}
