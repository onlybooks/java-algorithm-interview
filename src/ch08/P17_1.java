package ch08;

import datatype.ListNode;

public class P17_1 {
    public ListNode swapPairs(ListNode head) {
        // 스왑을 진행할 노드 선언
        ListNode node = head;

        // 현재 노드와 다음 노드가 존재하면 계속 진행
        while (node != null && node.next != null) {
            // 임시 변수를 이용해 값만 교환
            int tmp;
            tmp = node.val;
            node.val = node.next.val;
            node.next.val = tmp;
            // 두 칸 앞으로 이동
            node = node.next.next;
        }
        // 첫 번째 노드를 정답으로 리턴
        return head;
    }
}
