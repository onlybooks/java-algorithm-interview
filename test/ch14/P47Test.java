package ch14;

import datatype.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class P47Test {
    @Test
    void P47_1() {
        P47_1 s = new P47_1();
        assertEquals(3,
                s.maxDepth(new TreeNode(new Integer[]{3, 9, 20, null, null, 15, 7})));
    }

    @Test
    void P47_2() {
        P47_2 s = new P47_2();
        assertEquals(3,
                s.maxDepth(new TreeNode(new Integer[]{3, 9, 20, null, null, 15, 7})));
    }

    @Test
    void P47_3() {
        P47_3 s = new P47_3();
        assertEquals(3,
                s.maxDepth(new TreeNode(new Integer[]{3, 9, 20, null, null, 15, 7})));
    }
}