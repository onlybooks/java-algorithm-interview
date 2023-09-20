package ch08;

import datatype.ListNode;

public class P17_2 {
    public ListNode swapPairs(ListNode head) {
        // 값을 계산할 임시 노드 선언
        ListNode node = new ListNode(0);
        // 임시 노드를 첫 번째 노드로 선언
        ListNode root = node;
        // 다음 노드는 첫 번째 노드로
        node.next = head;
        // 다음 노드와 다음 다음 노드가 있으면 반복
        while (node.next != null && node.next.next != null) {
            // a는 다음 노드
            ListNode a = node.next;
            // b는 다음 다음 노드
            ListNode b = node.next.next;
            // 위치 변경
            a.next = b.next;
            node.next = b;
            node.next.next = a;
            // 두 칸 앞으로 이동
            node = node.next.next;
        }
        // 첫 번째 노드는 임시 노드이므로 그다음부터 결과로 리턴
        return root.next;
    }
}
