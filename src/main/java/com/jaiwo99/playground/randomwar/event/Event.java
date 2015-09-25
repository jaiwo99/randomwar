package com.jaiwo99.playground.randomwar.event;

import com.jaiwo99.playground.randomwar.system.Consumable;
import com.jaiwo99.playground.randomwar.system.Storeable;

/**
 * @author liang shi
 * @since 24.09.15
 */
public interface Event extends Consumable, Storeable {

    EventType getEventType();
}
