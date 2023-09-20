package ch17;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;


class P68Test {
    @Test
    void P68_1() {
        P68_1 s = new P68_1();
        assertTrue(s.isAnagram("anagram", "nagarma"));
    }

    @Test
    void P68_2() {
        P68_2 s = new P68_2();
        assertTrue(s.isAnagram("anagram", "nagarma"));
    }

    @Test
    void P68_3() {
        P68_3 s = new P68_3();
        assertTrue(s.isAnagram("anagram", "nagarma"));
    }
}