package com.jaiwo99.playground.randomwar.menu;

import com.jaiwo99.playground.randomwar.repository.EventStore;
import com.jaiwo99.playground.randomwar.repository.WarriorStore;

/**
 * This class contains all the necessary routing information of execution of a user action
 *
 * @author jaiwo99
 */
public class MenuActionFactory {

    private static final MenuActionFactory factory = new MenuActionFactory();

    private final WarriorStore warriorStore;
    private final EventStore eventStore;

    private MenuActionFactory() {
        warriorStore = WarriorStore.getInstance();
        eventStore = EventStore.getInstance();
    }

    public static final MenuActionFactory getInstance() {
        return factory;
    }

    public MenuAction getMenuActionByType(MenuActionType type) {
        switch (type) {
            case CREATE_NEW_WARRIOR:
                return new CreateWarriorMenuAction(warriorStore);
            case EXPLORE:
                return new WarriorExploreMenuAction(eventStore);
            case WIN_A_FIGHT:
                return new WinFightMenuAction(eventStore);
            case LOSE_A_FIGHT:
                return new LoseFightMenuAction(eventStore);
            case HEALED:
                return new WarriorHealedAction(eventStore);
            case GAME_OVER:
                return new WarriorGameOverAction(eventStore);
            case START_GAME:
                return new StartGameAction(eventStore);
            case SAVE:
            case BACK_TO_MAIN_MENU:
            case QUIT_GAME:
            case NONE:
            default:
                return new NoneMenuAction();
        }
    }
}
