package ch08;

import datatype.ListNode;

public class P15_1 {
    public ListNode reverse(ListNode node, ListNode prev) {
        // 현재 노드인 node가 널이면 리턴
        if (node == null)
            return prev;
        // 현재 노드의 다음 노드 미리 지정
        ListNode next = node.next;
        // 현재 노드의 다음으로 이전 노드 지정
        node.next = prev;
        // 다음 노드와 현재 노드를 파라미터로 하여 재귀 호출
        return reverse(next, node);
    }

    public ListNode reverseList(ListNode head) {
        return reverse(head, null);
    }
}
