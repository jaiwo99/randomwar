package com.jaiwo99.playground.randomwar.menu;

import com.jaiwo99.playground.randomwar.domain.Warrior;
import com.jaiwo99.playground.randomwar.repository.WarriorStore;

import java.util.Scanner;
import java.util.UUID;

/**
 * @author jaiwo99
 */
public class CreateWarriorMenuAction implements MenuAction {

    private final WarriorStore warriorStore;

    public CreateWarriorMenuAction(WarriorStore warriorStore) {
        this.warriorStore = warriorStore;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please give this warrior a name:");
        final String name;
        while (true) {
            String input = scanner.nextLine();
            if (input != null && !input.isEmpty()) {
                name = input;
                break;
            } else {
                System.out.println("Invalid input, please try again");
            }
        }
        warriorStore.saveWarrior(new Warrior(UUID.randomUUID().toString(), name));
        System.out.println(String.format("Warrior %s is created", name));
    }
}
