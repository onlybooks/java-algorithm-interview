package ch12;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class P35Test {
    @Test
    void P35_1() {
        P35_1 s = new P35_1();
        int r = s.numIslands(new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '1'}
        });
        assertEquals(2, r);
    }

    @Test
    void P35_2() {
        P35_2 s = new P35_2();
        int r = s.numIslands(new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '1'}
        });
        assertEquals(2, r);
    }
}