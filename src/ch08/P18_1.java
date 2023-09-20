package ch08;

import datatype.ListNode;

public class P18_1 {
    public ListNode oddEvenList(ListNode head) {
        // 예외 처리
        if (head == null)
            return null;
        // 홀수 노드
        ListNode odd = head;
        // 짝수 노드
        ListNode even = head.next;
        // 짝수 첫 번째 노드
        ListNode evenHead = even;

        // 반복하면서 홀짝 노드 처리
        while (even != null && even.next != null) {
            // 홀짝 노드의 다음 노드로 다음 다음 노드 지정
            odd.next = odd.next.next;
            even.next = even.next.next;
            // 홀짝 한 칸씩 진행
            odd = odd.next;
            even = even.next;
        }
        // 홀수 노드 마지막을 짝수 첫 번째와 연결
        odd.next = evenHead;
        // 첫 번째 노드 리턴
        return head;
    }
}
