package com.jaiwo99.playground.randomwar.event;

import com.jaiwo99.playground.randomwar.RandomWar;
import com.jaiwo99.playground.randomwar.constant.WarriorConstant;
import com.jaiwo99.playground.randomwar.domain.Warrior;
import com.jaiwo99.playground.randomwar.system.Position;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class GameOverEventTest {

    Warrior warrior;
    GameOverEvent event;

    @Before
    public void setUp() {
        event = new GameOverEvent();
        warrior = new Warrior("id", "name");
        warrior.health = 100;
        warrior.position = new Position(100, 100);
        warrior.score = 100;

        RandomWar.getInstance().currentWarrior = warrior;
    }

    @Test
    public void getEventType_should_return_correct_type() {
        assertThat(event.getEventType(), is(EventType.GAME_OVER));
    }

    @Test
    public void toDataString_should_convert_object_to_string() {
        assertThat(event.toDataString(), is(EventType.GAME_OVER.name()));
    }

    @Test
    public void fromDataString_should_create_new_event() {
        assertThat(GameOverEvent.fromString("whatever").getEventType(), is(EventType.GAME_OVER));
    }

    @Test
    public void consume_should_reset_warrior_data() {
        event.consume();

        assertThat(RandomWar.getInstance().currentWarrior.health, is(WarriorConstant.WARRIOR_INIT_HEALTH));
        assertThat(RandomWar.getInstance().currentWarrior.score, is(WarriorConstant.WARRIOR_INIT_SCORE));
        assertThat(RandomWar.getInstance().currentWarrior.position.x, is(WarriorConstant.WARRIOR_INIT_X));
        assertThat(RandomWar.getInstance().currentWarrior.position.y, is(WarriorConstant.WARRIOR_INIT_Y));
    }
}