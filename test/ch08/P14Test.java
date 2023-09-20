package ch08;

import datatype.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class P14Test {
    @Test
    void P14_1() {
        P14_1 s = new P14_1();
        ListNode r = s.mergeTwoLists(
                new ListNode(1,
                        new ListNode(2,
                                new ListNode(5)
                        )
                ),
                new ListNode(1,
                        new ListNode(3,
                                new ListNode(4)
                        )
                )
        );
        assertEquals(1, r.val);
        assertEquals(1, r.next.val);
        assertEquals(2, r.next.next.val);
        assertEquals(3, r.next.next.next.val);
        assertEquals(4, r.next.next.next.next.val);
        assertEquals(5, r.next.next.next.next.next.val);
    }

    @Test
    void P14_2() {
        P14_2 s = new P14_2();
        ListNode r = s.mergeTwoLists(
                new ListNode(1,
                        new ListNode(2,
                                new ListNode(5)
                        )
                ),
                new ListNode(1,
                        new ListNode(3,
                                new ListNode(4)
                        )
                )
        );
        assertEquals(1, r.val);
        assertEquals(1, r.next.val);
        assertEquals(2, r.next.next.val);
        assertEquals(3, r.next.next.next.val);
        assertEquals(4, r.next.next.next.next.val);
        assertEquals(5, r.next.next.next.next.next.val);
    }
}