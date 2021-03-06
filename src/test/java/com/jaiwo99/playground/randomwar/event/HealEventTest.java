package com.jaiwo99.playground.randomwar.event;

import com.jaiwo99.playground.randomwar.RandomWar;
import com.jaiwo99.playground.randomwar.constant.WarriorConstant;
import com.jaiwo99.playground.randomwar.domain.Warrior;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class HealEventTest {

    Warrior warrior;
    HealEvent event;

    @Before
    public void setUp() {
        event = new HealEvent();
        warrior = new Warrior("id", "name");
        RandomWar.getInstance().currentWarrior = warrior;
    }

    @Test
    public void getEventType_should_return_correct_type() {
        assertThat(event.getEventType(), is(EventType.HEAL));
    }

    @Test
    public void toDataString_should_convert_object_to_string() {
        assertThat(event.toDataString(), is(EventType.HEAL.name()));
    }

    @Test
    public void fromDataString_should_create_new_event() {
        assertThat(HealEvent.fromString("whatever").getEventType(), is(EventType.HEAL));
    }

    @Test
    public void consume_should_increase_health() {
        event.consume();
        assertThat(RandomWar.getInstance().currentWarrior.health, is(WarriorConstant.WARRIOR_INIT_HEALTH + 1));
    }
}