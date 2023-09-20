package ch06;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class P1Test {
    @Test
    void P1_1() {
        P1_1 s = new P1_1();
        assertTrue(s.isPalindrome("Do geese see God?"));
        assertTrue(s.isPalindrome("Hannah"));
        assertFalse(s.isPalindrome("Hang up!"));
    }

    @Test
    void P1_2() {
        P1_2 s = new P1_2();
        assertTrue(s.isPalindrome("Do geese see God?"));
        assertTrue(s.isPalindrome("Hannah"));
        assertFalse(s.isPalindrome("Hang up!"));
    }

    @Test
    void P1_3() {
        P1_3 s = new P1_3();
        assertTrue(s.isPalindrome("Do geese see God?"));
        assertTrue(s.isPalindrome("Hannah"));
        assertFalse(s.isPalindrome("Hang up!"));
    }
}