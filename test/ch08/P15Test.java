package ch08;

import datatype.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class P15Test {
    @Test
    void P15_1() {
        P15_1 s = new P15_1();
        ListNode r = s.reverseList(
                new ListNode(1,
                        new ListNode(2,
                                new ListNode(3,
                                        new ListNode(4,
                                                new ListNode(5)
                                        )
                                )
                        )
                )
        );
        assertEquals(5, r.val);
        assertEquals(4, r.next.val);
        assertEquals(3, r.next.next.val);
        assertEquals(2, r.next.next.next.val);
        assertEquals(1, r.next.next.next.next.val);
    }

    @Test
    void P15_2() {
        P15_2 s = new P15_2();
        ListNode r = s.reverseList(
                new ListNode(1,
                        new ListNode(2,
                                new ListNode(3,
                                        new ListNode(4,
                                                new ListNode(5)
                                        )
                                )
                        )
                )
        );
        assertEquals(5, r.val);
        assertEquals(4, r.next.val);
        assertEquals(3, r.next.next.val);
        assertEquals(2, r.next.next.next.val);
        assertEquals(1, r.next.next.next.next.val);
    }

    @Test
    void P15_3() {
        P15_3 s = new P15_3();
        ListNode r = s.reverseList(
                new ListNode(1,
                        new ListNode(2,
                                new ListNode(3,
                                        new ListNode(4,
                                                new ListNode(5)
                                        )
                                )
                        )
                )
        );
        assertEquals(5, r.val);
        assertEquals(4, r.next.val);
        assertEquals(3, r.next.next.val);
        assertEquals(2, r.next.next.next.val);
        assertEquals(1, r.next.next.next.next.val);
    }
}