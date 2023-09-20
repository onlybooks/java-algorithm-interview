package ch08;

import datatype.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;


class P13Test {
    @Test
    void P13_1() {
        P13_1 s = new P13_1();
        assertTrue(s.isPalindrome(new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(2,
                                        new ListNode(1)
                                )
                        )
                )
        )));
    }

    @Test
    void P13_2() {
        P13_2 s = new P13_2();
        assertTrue(s.isPalindrome(new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(2,
                                        new ListNode(1)
                                )
                        )
                )
        )));
    }

    @Test
    void P13_3() {
        P13_3 s = new P13_3();
        assertTrue(s.isPalindrome(new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(2,
                                        new ListNode(1)
                                )
                        )
                )
        )));
    }

    @Test
    void P13_4() {
        P13_4 s = new P13_4();
        assertTrue(s.isPalindrome(new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(2,
                                        new ListNode(1)
                                )
                        )
                )
        )));
    }
}