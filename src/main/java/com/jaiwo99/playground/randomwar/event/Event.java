package com.jaiwo99.playground.randomwar.event;

import com.jaiwo99.playground.randomwar.system.Consumable;
import com.jaiwo99.playground.randomwar.system.Storeable;

/**
 * @author liang shi
 */
public interface Event extends Consumable, Storeable {

    EventType getEventType();
}
