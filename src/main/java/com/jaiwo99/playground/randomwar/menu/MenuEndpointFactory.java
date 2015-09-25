package com.jaiwo99.playground.randomwar.menu;

import com.jaiwo99.playground.randomwar.event.EventType;
import com.jaiwo99.playground.randomwar.repository.WarriorStore;

import static com.jaiwo99.playground.randomwar.event.EventType.*;
import static java.util.concurrent.ThreadLocalRandom.current;

/**
 * @author jaiwo99
 */
public class MenuEndpointFactory {

    private static final MenuEndpointFactory factory = new MenuEndpointFactory();

    private final WarriorStore warriorStore;

    private MenuEndpointFactory() {
        warriorStore = WarriorStore.getInstance();
    }

    public static final MenuEndpointFactory getInstance() {
        return factory;
    }

    public Menu getMenuEndpointByType(MenuActionType type) {
        switch (type) {
            case WIN_A_FIGHT:
            case START_GAME:
            case CONTINUE_GAME:
            case HEALED:
            case NONE:
                return new GameMenu();
            case LOSE_A_FIGHT:
                return new LoseFightMenu();
            case LOAD_EXISTING_WARRIOR:
                return new ChooseWarriorMenu(warriorStore.load());
            case EXPLORE:
                return rollFollowedMenuForExplore();
            case QUIT_GAME:
                return new QuitGameMenu();
            case CREATE_NEW_WARRIOR:
            case SAVE:
            case BACK_TO_MAIN_MENU:
            case GAME_OVER:
            default:
                return new MainMenu();
        }
    }

    /**
     * Random a followed event type for explore event and return related menu.
     */
    private Menu rollFollowedMenuForExplore() {

        final EventType eventType = generateEventFollowsExplore();
        if (EventType.FIGHT.equals(eventType)) {
            return new WarriorFightMenu();
        } else if (EventType.HEAL.equals(eventType)) {
            return new WarriorHealedMenu();
        } else if (EventType.NONE.equals(eventType)) {
            return new GameMenu();
        } else {
            throw new UnsupportedOperationException(String.format("Event type %s is not supported yet!", eventType));
        }
    }

    private EventType generateEventFollowsExplore() {
        EventType[] eventTypes = new EventType[] {FIGHT, FIGHT, FIGHT, FIGHT, FIGHT, HEAL, NONE};
        return eventTypes[current().nextInt(eventTypes.length)];
    }
}
