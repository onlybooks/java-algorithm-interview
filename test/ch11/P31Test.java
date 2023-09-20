package ch11;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class P31Test {
    @Test
    void P31_1() {
        P31_1 s = new P31_1();
        assertEquals(3, s.numJewelsInStones("aA", "aAAbbbb"));
    }

    @Test
    void P31_2() {
        P31_2 s = new P31_2();
        assertEquals(3, s.numJewelsInStones("aA", "aAAbbbb"));
    }

    @Test
    void P31_3() {
        P31_3 s = new P31_3();
        assertEquals(3, s.numJewelsInStones("aA", "aAAbbbb"));
    }
}