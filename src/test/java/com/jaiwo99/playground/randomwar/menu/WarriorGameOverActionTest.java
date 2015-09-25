package com.jaiwo99.playground.randomwar.menu;

import com.jaiwo99.playground.randomwar.RandomWar;
import com.jaiwo99.playground.randomwar.constant.WarriorConstant;
import com.jaiwo99.playground.randomwar.domain.Warrior;
import com.jaiwo99.playground.randomwar.event.Event;
import com.jaiwo99.playground.randomwar.event.EventType;
import com.jaiwo99.playground.randomwar.repository.EventStore;
import com.jaiwo99.playground.randomwar.system.Position;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class WarriorGameOverActionTest {

    Warrior warrior;
    @Mock
    EventStore eventStore;
    WarriorGameOverAction warriorGameOverAction;

    @Before
    public void setUp() {
        warrior = new Warrior("id", "name");
        warrior.health = 100;
        warrior.score = 100;
        warrior.position = new Position(2,3);
        RandomWar.getInstance().currentWarrior = warrior;

        warriorGameOverAction = new WarriorGameOverAction(eventStore);
    }

    @Test
    public void execute_should_consume_event() {
        warriorGameOverAction.execute();

        assertThat(RandomWar.getInstance().currentWarrior.position.x, is(WarriorConstant.WARRIOR_INIT_X));
        assertThat(RandomWar.getInstance().currentWarrior.position.y, is(WarriorConstant.WARRIOR_INIT_Y));
        assertThat(RandomWar.getInstance().currentWarrior.health, is(WarriorConstant.WARRIOR_INIT_HEALTH));
        assertThat(RandomWar.getInstance().currentWarrior.score, is(WarriorConstant.WARRIOR_INIT_SCORE));
    }

    @Test
    public void execute_should_save_event() {
        warriorGameOverAction.execute();

        ArgumentCaptor<Event> captor = ArgumentCaptor.forClass(Event.class);
        verify(eventStore, times(1)).saveEvent(captor.capture());
        assertThat(captor.getValue().getEventType(), is(EventType.GAME_OVER));
    }
}