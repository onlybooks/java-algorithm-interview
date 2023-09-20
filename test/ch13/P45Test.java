package ch13;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class P45Test {
    @Test
    void P45_1() {
        P45_1 s = new P45_1();
        assertEquals(500,
                s.findCheapestPrice(3, new int[][]{
                        new int[]{0, 1, 100},
                        new int[]{1, 2, 200},
                        new int[]{0, 2, 500},
                }, 0, 2, 0)
        );
    }

    @Test
    void P45_2() {
        P45_2 s = new P45_2();
        assertEquals(500,
                s.findCheapestPrice(3, new int[][]{
                        new int[]{0, 1, 100},
                        new int[]{1, 2, 200},
                        new int[]{0, 2, 500},
                }, 0, 2, 0)
        );
    }

    @Test
    void P45_3() {
        P45_3 s = new P45_3();
        assertEquals(500,
                s.findCheapestPrice(3, new int[][]{
                        new int[]{0, 1, 100},
                        new int[]{1, 2, 200},
                        new int[]{0, 2, 500},
                }, 0, 2, 0)
        );
    }
}