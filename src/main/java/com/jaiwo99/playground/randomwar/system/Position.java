package com.jaiwo99.playground.randomwar.system;

/**
 * @author liang shi
 * @since 24.09.15
 */
public class Position {
    public final int x;
    public final int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return String.format("(%s, %s)", x, y);
    }
}
