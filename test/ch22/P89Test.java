package ch22;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class P89Test {
    @Test
    void P89_1() {
        P89_1 s = new P89_1();
        assertEquals(2, s.majorityElement(new int[]{2, 2, 1, 1, 3, 2, 2}));
    }

    @Test
    void P89_2() {
        P89_2 s = new P89_2();
        assertEquals(2, s.majorityElement(new int[]{2, 2, 1, 1, 3, 2, 2}));
    }

    @Test
    void P89_3() {
        P89_3 s = new P89_3();
        assertEquals(2, s.majorityElement(new int[]{2, 2, 1, 1, 3, 2, 2}));
    }

    @Test
    void P89_4() {
        P89_4 s = new P89_4();
        assertEquals(2, s.majorityElement(new int[]{2, 2, 1, 1, 3, 2, 2}));
    }
}