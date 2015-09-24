package com.jaiwo99.playground.randomwar.system;

import static java.util.concurrent.ThreadLocalRandom.current;

/**
 * @author liang shi
 * @since 24.09.15
 */
public class PositionGenerator {

    private PositionGenerator() {
    }

    /**
     * Generate a random position
     * @see java.util.concurrent.ThreadLocalRandom
     */
    public static Position generate() {
        return new Position(current().nextInt(1, 100), current().nextInt(1, 100));
    }
}
