package ch07;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class P8Test {
    @Test
    void P8_1() {
        P8_1 s = new P8_1();
        assertEquals(6, s.trap(new int[]{1, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

    @Test
    void P8_2() {
        P8_2 s = new P8_2();
        assertEquals(6, s.trap(new int[]{1, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

    @Test
    void P8_3() {
        P8_3 s = new P8_3();
        assertEquals(6, s.trap(new int[]{1, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
}