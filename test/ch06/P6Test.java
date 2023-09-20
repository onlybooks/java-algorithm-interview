package ch06;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class P6Test {
    @Test
    void P6_1() {
        P6_1 s = new P6_1();
        assertEquals("dcbabcd", s.longestPalindrome("dcbabcdd"));
    }

    @Test
    void P6_2() {
        P6_2 s = new P6_2();
        assertEquals("dcbabcd", s.longestPalindrome("dcbabcdd"));
    }
}