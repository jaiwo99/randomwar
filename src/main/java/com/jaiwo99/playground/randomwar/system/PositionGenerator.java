package com.jaiwo99.playground.randomwar.system;

import com.jaiwo99.playground.randomwar.constant.MapConstant;

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
        return new Position(current().nextInt(MapConstant.MAP_INIT_AXIS_X), current().nextInt(MapConstant.MAP_INIT_AXIS_Y));
    }
}
