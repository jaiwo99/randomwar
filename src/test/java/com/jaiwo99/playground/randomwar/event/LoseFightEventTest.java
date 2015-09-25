package com.jaiwo99.playground.randomwar.event;

import com.jaiwo99.playground.randomwar.RandomWar;
import com.jaiwo99.playground.randomwar.constant.WarriorConstant;
import com.jaiwo99.playground.randomwar.domain.Warrior;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class LoseFightEventTest {

    Warrior warrior;
    LoseFightEvent event;

    @Before
    public void setUp() {
        event = new LoseFightEvent();
        warrior = new Warrior("id", "name");
        RandomWar.getInstance().currentWarrior = warrior;
    }

    @Test
    public void getEventType_should_return_correct_type() {
        assertThat(event.getEventType(), is(EventType.LOSE_FIGHT));
    }

    @Test
    public void toDataString_should_convert_object_to_string() {
        assertThat(event.toDataString(), is(EventType.LOSE_FIGHT.name()));
    }

    @Test
    public void fromDataString_should_create_new_event() {
        assertThat(LoseFightEvent.fromString("whatever").getEventType(), is(EventType.LOSE_FIGHT));
    }

    @Test
    public void consume_should_decrease_health() {
        event.consume();
        assertThat(RandomWar.getInstance().currentWarrior.health, is(WarriorConstant.WARRIOR_INIT_HEALTH - 1));
    }
}