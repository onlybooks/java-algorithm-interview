package ch13;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class P44Test {
    @Test
    void P44_1() {
        P44_1 s = new P44_1();
        assertEquals(5,
                s.networkDelayTime(new int[][]{
                        new int[]{3, 1, 5},
                        new int[]{3, 2, 2},
                        new int[]{2, 1, 2},
                        new int[]{3, 4, 1},
                        new int[]{4, 5, 1},
                        new int[]{5, 6, 1},
                        new int[]{6, 7, 1},
                        new int[]{7, 8, 1},
                        new int[]{8, 1, 1},
                }, 8, 3));
    }

    @Test
    void P44_2() {
        P44_2 s = new P44_2();
        assertEquals(5,
                s.networkDelayTime(new int[][]{
                        new int[]{3, 1, 5},
                        new int[]{3, 2, 2},
                        new int[]{2, 1, 2},
                        new int[]{3, 4, 1},
                        new int[]{4, 5, 1},
                        new int[]{5, 6, 1},
                        new int[]{6, 7, 1},
                        new int[]{7, 8, 1},
                        new int[]{8, 1, 1},
                }, 8, 3));
    }
}