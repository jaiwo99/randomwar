package com.jaiwo99.playground.randomwar.menu;

import com.jaiwo99.playground.randomwar.RandomWar;
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
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class WarriorExploreMenuActionTest {

    Warrior warrior;
    @Mock
    EventStore eventStore;
    WarriorExploreMenuAction warriorExploreMenuAction;

    @Before
    public void setUp() {
        warrior = new Warrior("id", "name");
        RandomWar.getInstance().currentWarrior = warrior;

        warriorExploreMenuAction = new WarriorExploreMenuAction(eventStore);
    }

    @Test
    public void execute_should_consume_event() {
        Position position = RandomWar.getInstance().currentWarrior.position;

        warriorExploreMenuAction.execute();

        assertThat(RandomWar.getInstance().currentWarrior.position, not(position));
    }

    @Test
    public void execute_should_save_event() {
        warriorExploreMenuAction.execute();

        ArgumentCaptor<Event> captor = ArgumentCaptor.forClass(Event.class);
        verify(eventStore, times(1)).saveEvent(captor.capture());
        assertThat(captor.getValue().getEventType(), is(EventType.EXPLORE));
    }
}