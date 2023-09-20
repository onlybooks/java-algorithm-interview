package ch09;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class P21Test {
    @Test
    void P21_1() {
        P21_1 s = new P21_1();
        assertEquals("acdb", s.removeDuplicateLetters("dbacdcbc"));
    }

    @Test
    void P21_2() {
        P21_2 s = new P21_2();
        assertEquals("acdb", s.removeDuplicateLetters("dbacdcbc"));
    }

    @Test
    void P23_3() {
        P21_3 s = new P21_3();
        assertEquals("acdb", s.removeDuplicateLetters("dbacdcbc"));
    }
}