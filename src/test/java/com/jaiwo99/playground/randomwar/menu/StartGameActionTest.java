package com.jaiwo99.playground.randomwar.menu;

import com.jaiwo99.playground.randomwar.RandomWar;
import com.jaiwo99.playground.randomwar.constant.WarriorConstant;
import com.jaiwo99.playground.randomwar.domain.Warrior;
import com.jaiwo99.playground.randomwar.event.HealEvent;
import com.jaiwo99.playground.randomwar.repository.EventStore;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class StartGameActionTest {

    Warrior warrior;
    @Mock
    EventStore eventStore;
    StartGameAction startGameAction;

    @Before
    public void setUp() {
        warrior = new Warrior("id", "name");
        RandomWar.getInstance().currentWarrior = warrior;

        startGameAction = new StartGameAction(eventStore);
    }

    @Test
    public void execute_should_load_and_consume_events() {
        when(eventStore.loadEvents()).thenReturn(Arrays.asList(new HealEvent(), new HealEvent()));

        startGameAction.execute();

        verify(eventStore, times(1)).loadEvents();
        assertThat(RandomWar.getInstance().currentWarrior.health, is(WarriorConstant.WARRIOR_INIT_HEALTH + 2));
    }

}