package ch08;

import datatype.ListNode;

public class P19_1 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 예외 처리
        if (head == null)
            return null;
        // 임시 노드 선언
        ListNode root = new ListNode(0);
        // 임시 노드 다음으로 노드 시작
        root.next = head;
        // 임시 노드부터 시작해 변경 필요한 위치 앞으로 이동
        ListNode start = root;
        for (int i = 0; i < left - 1; i++)
            start = start.next;
        // 변경이 필요한 마지막 위치 선언
        ListNode end = start.next;
        // right - left만큼 위치 변경 진행
        for (int i = 0; i < right - left; i++) {
            ListNode tmp = start.next;
            start.next = end.next;
            end.next = end.next.next;
            start.next.next = tmp;
        }
        // 첫 번째 노드는 임시 노드이므로 그다음부터 결과로 리턴
        return root.next;
    }
}
