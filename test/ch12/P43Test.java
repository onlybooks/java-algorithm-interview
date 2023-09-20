package ch12;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;


class P43Test {
    @Test
    void P43_1() {
        P43_1 s = new P43_1();
        assertTrue(s.canFinish(3, new int[][]{new int[]{1, 0}, new int[]{2, 1}}));
    }

    @Test
    void P43_2() {
        P43_2 s = new P43_2();
        assertTrue(s.canFinish(3, new int[][]{new int[]{1, 0}, new int[]{2, 1}}));
    }

    @Test
    void P43_3() {
        P43_3 s = new P43_3();
        assertTrue(s.canFinish(3, new int[][]{new int[]{1, 0}, new int[]{2, 1}}));
    }
}