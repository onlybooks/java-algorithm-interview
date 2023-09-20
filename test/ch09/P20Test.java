package ch09;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class P20Test {
    @Test
    void P20_1() {
        P20_1 s = new P20_1();
        assertTrue(s.isValid("(){}[]"));
    }

    @Test
    void P20_2() {
        P20_2 s = new P20_2();
        assertTrue(s.isValid("(){}[]"));
    }
}