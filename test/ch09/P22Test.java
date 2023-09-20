package ch09;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class P22Test {
    @Test
    void P22_1() {
        P22_1 s = new P22_1();
        assertArrayEquals(
                new int[]{1, 1, 4, 2, 1, 1, 0, 0},
                s.dailyTemperatures(new int[]{23, 24, 25, 21, 19, 22, 26, 23})
        );
    }

    @Test
    void P22_2() {
        P22_2 s = new P22_2();
        assertArrayEquals(
                new int[]{1, 1, 4, 2, 1, 1, 0, 0},
                s.dailyTemperatures(new int[]{23, 24, 25, 21, 19, 22, 26, 23})
        );
    }
}