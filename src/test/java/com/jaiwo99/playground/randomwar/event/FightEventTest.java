package com.jaiwo99.playground.randomwar.event;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class FightEventTest {

    FightEvent event;

    @Before
    public void setUp() {
        event = new FightEvent();
    }

    @Test
    public void getEventType_should_return_correct_type() {
        assertThat(event.getEventType(), is(EventType.FIGHT));
    }

    @Test
    public void toDataString_should_convert_object_to_string() {
        assertThat(event.toDataString(), is(EventType.FIGHT.name()));
    }

    @Test
    public void fromDataString_should_create_new_fight_event() {
        assertThat(FightEvent.fromString("whatever").getEventType(), is(EventType.FIGHT));
    }
}