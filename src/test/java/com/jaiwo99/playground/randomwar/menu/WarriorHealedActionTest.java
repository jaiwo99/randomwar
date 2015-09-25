package com.jaiwo99.playground.randomwar.menu;

import com.jaiwo99.playground.randomwar.RandomWar;
import com.jaiwo99.playground.randomwar.constant.WarriorConstant;
import com.jaiwo99.playground.randomwar.domain.Warrior;
import com.jaiwo99.playground.randomwar.event.Event;
import com.jaiwo99.playground.randomwar.event.EventType;
import com.jaiwo99.playground.randomwar.repository.EventStore;
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
public class WarriorHealedActionTest {

    Warrior warrior;
    @Mock
    EventStore eventStore;
    WarriorHealedAction warriorHealedAction;

    @Before
    public void setUp() {
        warrior = new Warrior("id", "name");
        RandomWar.getInstance().currentWarrior = warrior;

        warriorHealedAction = new WarriorHealedAction(eventStore);
    }

    @Test
    public void execute_should_consume_event() {
        warriorHealedAction.execute();

        assertThat(RandomWar.getInstance().currentWarrior.health, is(WarriorConstant.WARRIOR_INIT_HEALTH + 1));
    }

    @Test
    public void execute_should_save_event() {
        warriorHealedAction.execute();

        ArgumentCaptor<Event> captor = ArgumentCaptor.forClass(Event.class);
        verify(eventStore, times(1)).saveEvent(captor.capture());
        assertThat(captor.getValue().getEventType(), is(EventType.HEAL));
    }
}