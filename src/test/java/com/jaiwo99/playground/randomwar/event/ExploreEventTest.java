package com.jaiwo99.playground.randomwar.event;

import com.jaiwo99.playground.randomwar.RandomWar;
import com.jaiwo99.playground.randomwar.domain.Warrior;
import com.jaiwo99.playground.randomwar.system.Position;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ExploreEventTest {

    Warrior warrior;
    ExploreEvent event;

    @Before
    public void setUp() {
        event = new ExploreEvent(new Position(1,1));
        warrior = new Warrior("id", "name");
        RandomWar.getInstance().currentWarrior = warrior;
    }

    @Test
    public void getEventType_should_return_correct_type() {
        assertThat(event.getEventType(), is(EventType.EXPLORE));
    }

    @Test
    public void consume_should_set_new_position() {
        event.consume();
        assertThat(RandomWar.getInstance().currentWarrior.position.x, is(1));
        assertThat(RandomWar.getInstance().currentWarrior.position.y, is(1));
    }

    @Test
    public void toDataString_should_return_correct_format() {
        assertThat(event.toDataString(), is("EXPLORE;1;1"));
    }

    @Test
    public void fromDataString_should_build_object_correctly() {
        final ExploreEvent newEvent = ExploreEvent.fromString("EXPLORE;100;100");
        assertThat(newEvent.position.x, is(100));
        assertThat(newEvent.position.y, is(100));
    }

}