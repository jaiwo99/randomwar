package com.jaiwo99.playground.randomwar.domain;

import com.jaiwo99.playground.randomwar.constant.WarriorConstant;
import com.jaiwo99.playground.randomwar.event.Event;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static com.jaiwo99.playground.randomwar.constant.DataStoreConstant.DATA_SEPARATOR_SYMBOL;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class WarriorTest {

    Warrior warrior;

    @Mock
    Event event;

    @Before
    public void setUp() {
        warrior = new Warrior("id", "name");
    }

    @Test
    public void constructor_should_init_id() {
        assertThat(warrior.id, is("id"));
    }

    @Test
    public void constructor_should_init_name() {
        assertThat(warrior.name, is("name"));
    }

    @Test
    public void constructor_should_init_position() {
        assertThat(warrior.position.x, is(WarriorConstant.WARRIOR_INIT_X));
        assertThat(warrior.position.y, is(WarriorConstant.WARRIOR_INIT_Y));
    }

    @Test
    public void constructor_should_init_health() {
        assertThat(warrior.health, is(WarriorConstant.WARRIOR_INIT_HEALTH));
    }

    @Test
    public void constructor_should_init_score() {
        assertThat(warrior.score, is(WarriorConstant.WARRIOR_INIT_SCORE));
    }

    @Test
    public void consume_should_consume_event() {
        warrior.consume(event);
        verify(event, times(1)).consume();
    }

    @Test
    public void toDataString_should_convert_data_with_correct_format() {
        assertThat(warrior.toDataString(), is("id" + DATA_SEPARATOR_SYMBOL + "name"));
    }
}