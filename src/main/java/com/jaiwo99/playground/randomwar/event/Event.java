package com.jaiwo99.playground.randomwar.event;

import com.jaiwo99.playground.randomwar.system.Consumable;

/**
 * @author liang shi
 * @since 24.09.15
 */
public interface Event extends Consumable {

    EventType getEventType();
}
