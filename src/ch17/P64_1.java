package ch17;

import datatype.ListNode;

public class P64_1 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 두 노드 중 한쪽이 널이면 아닌 노드를 리턴
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        // 앞에 노드가 값이 더 크다면 스왑 진행
        if (l1.val > l2.val) {
            ListNode temp = l1;
            l1 = l2;
            l2 = temp;
        }
        // 앞에 노드의 다음 결과는 재귀로 처리한 결과 지정
        l1.next = mergeTwoLists(l1.next, l2);
        // l1쪽으로 작은 노드를 스왑하므로 l1 리턴
        return l1;
    }

    public ListNode sortList(ListNode head) {
        // 널인 노드까지 분할되면 아무런 처리 없이 리턴
        if (head == null || head.next == null) return head;

        // 러너 기법 활용, 빠른 노드가 끝까지 갈 때 느린(slow) 노드는 중간까지 이동한다.
        ListNode half = null, slow = head, fast = head;
        while (fast != null && fast.next != null) {
            half = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        // head를 시작으로 하는 노드와 slow를 시작하는 노드의 연결고리를 끊는다.
        half.next = null;

        // 분할(divide) 재귀 호출, 각 노드는 거듭된 분할의 결과로 더 이상 쪼갤 수 없는 단위까지 분할된다.
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);

        // 정복(conquer)을 시작하고, 결과를 정답으로 리턴
        return mergeTwoLists(l1, l2);
    }
}