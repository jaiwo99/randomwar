package com.jaiwo99.playground.randomwar.menu;

import com.jaiwo99.playground.randomwar.domain.Warrior;
import com.jaiwo99.playground.randomwar.repository.WarriorStore;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.ByteArrayInputStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class CreateWarriorMenuActionTest {

    CreateWarriorMenuAction createWarriorMenuAction;

    @Mock
    WarriorStore warriorStore;

    @Before
    public void setUp() {
        createWarriorMenuAction = new CreateWarriorMenuAction(warriorStore);
    }

    @Test
    public void execute_should_call_warrior_store() {
        ByteArrayInputStream in = new ByteArrayInputStream("Luke".getBytes());
        System.setIn(in);

        createWarriorMenuAction.execute();

        System.setIn(System.in);

        ArgumentCaptor<Warrior> captor = ArgumentCaptor.forClass(Warrior.class);
        verify(warriorStore, times(1)).saveWarrior(captor.capture());
        assertThat(captor.getValue().name, is("Luke"));
    }

}