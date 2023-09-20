package ch07;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class P7Test {
    @Test
    void P7_1() {
        P7_1 s = new P7_1();
        assertArrayEquals(new int[]{0, 1}, s.twoSum(new int[]{2, 6, 11, 15}, 8));
    }

    @Test
    void P7_2() {
        P7_2 s = new P7_2();
        assertArrayEquals(new int[]{0, 1}, s.twoSum(new int[]{2, 6, 11, 15}, 8));
    }

    @Test
    void P7_3() {
        P7_3 s = new P7_3();
        assertArrayEquals(new int[]{0, 1}, s.twoSum(new int[]{2, 6, 11, 15}, 8));
    }

    @Test
    void P7_4() {
        P7_4 s = new P7_4();
        assertArrayEquals(new int[]{0, 1}, s.twoSum(new int[]{2, 6, 11, 15}, 8));
    }

    @Test
    void P7_5() {
        P7_5 s = new P7_5();
        assertArrayEquals(new int[]{0, 1}, s.twoSum(new int[]{2, 6, 11, 15}, 8));
    }
}