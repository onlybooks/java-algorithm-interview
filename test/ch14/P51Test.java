package ch14;

import datatype.TreeNode;
import org.junit.jupiter.api.Test;

class P51Test {
    @Test
    void P51_1() {
        P51_1 s = new P51_1();
        TreeNode r = s.mergeTrees(
                new TreeNode(new Integer[]{1, 4, 2, 5}),
                new TreeNode(new Integer[]{2, 1, 3, null, 4, null, 7})
        );
        System.out.println(r.prettyPrint());
    }

    @Test
    void P51_2() {
        P51_2 s = new P51_2();
        TreeNode r = s.mergeTrees(
                new TreeNode(new Integer[]{1, 4, 2, 5}),
                new TreeNode(new Integer[]{2, 1, 3, null, 4, null, 7})
        );
        System.out.println(r.prettyPrint());
    }
}