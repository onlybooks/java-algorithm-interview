package ch13;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class P46Test {
    @Test
    void P46_1() {
        P46_1 s = new P46_1();
        assertEquals(11,
                s.solution(new int[][]{
                        {1, 0, 1, 1, 1},
                        {1, 0, 1, 0, 1},
                        {1, 0, 1, 1, 1},
                        {1, 1, 1, 0, 1},
                        {0, 0, 0, 0, 1}
                })
        );
    }
}