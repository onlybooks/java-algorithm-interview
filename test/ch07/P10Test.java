package ch07;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class P10Test {
    @Test
    void P10_1() {
        P10_1 s = new P10_1();
        assertEquals(4, s.arrayPairSum(new int[]{1, 3, 4, 2}));
    }

    @Test
    void P10_2() {
        P10_2 s = new P10_2();
        assertEquals(4, s.arrayPairSum(new int[]{1, 3, 4, 2}));
    }

    @Test
    void P10_3() {
        P10_3 s = new P10_3();
        assertEquals(4, s.arrayPairSum(new int[]{1, 3, 4, 2}));
    }
}