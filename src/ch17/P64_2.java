package ch17;

import datatype.ListNode;

public class P64_2 {
    public void quicksort(ListNode head, ListNode tail) {
        // 단일 노드일때는 그냥 리턴
        if (head == tail) return;
        // 연결 리스트이기 때문에 로무토 파티션이 아닌 편의상 첫 번째 노드를 피벗으로 선택
        ListNode pivot = head;
        // 왼쪽 포인터는 첫 번째 노드
        ListNode left = head;
        // 오른쪽 포인터는 그다음 노드
        ListNode right = head.next;

        // 오른쪽 포인터가 맨 끝에 도달할 때까지 진행
        while (right != tail) {
            if (right.val < pivot.val) {
                // 왼쪽 포인터 진행
                left = left.next;
                // 스왑, 연결 리스트이므로 노드 처리를 단순하게 하기 위해 값만 교환
                int temp = left.val;
                left.val = right.val;
                right.val = temp;
            }
            // 오른쪽 포인터 진행
            right = right.next;
        }
        // 피벗과 왼쪽 포인터 값 교환, 피벗은 첫 번째 노드
        int temp = head.val;
        head.val = left.val;
        left.val = temp;

        // 왼쪽 포인터를 중심으로 분할하여 재귀 호출
        quicksort(head, left);
        quicksort(left.next, tail);
    }

    public ListNode sortList(ListNode head) {
        // 연결 리스트의 마지막은 널이므로 tail을 null로 하여 호출
        quicksort(head, null);
        // 정렬이 끝나면 첫 번째 노드인 head를 결과로 리턴
        return head;
    }
}
