package com.jaiwo99.playground.randomwar.event;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class NoneEventTest {

    NoneEvent event;

    @Before
    public void setUp() {
        event = new NoneEvent();
    }

    @Test
    public void getEventType_should_return_correct_type() {
        assertThat(event.getEventType(), is(EventType.NONE));
    }

    @Test
    public void toDataString_should_convert_object_to_string() {
        assertThat(event.toDataString(), is(EventType.NONE.name()));
    }

    @Test
    public void fromDataString_should_create_new_event() {
        assertThat(NoneEvent.fromString("whatever").getEventType(), is(EventType.NONE));
    }
}