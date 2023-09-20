package ch08;

import datatype.ListNode;

public class P16_2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 값을 계산할 임시 노드 선언
        ListNode node = new ListNode(0);
        // 임시 노드를 첫 번째 노드로 선언
        ListNode root = node;

        // 자릿수의 합(sum), 자리올림수(carry), 나머지(remainder)를 저장할 변수 선언
        int sum, carry = 0, remainder;
        // 모든 연결 리스트를 끝까지 순회하고, 자리올림수도 0이 될때까지 진행
        while (l1 != null || l2 != null || carry != 0) {
            sum = 0;
            // 첫 번째 연결 리스트 합산 및 진행
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            // 두 번째 연결 리스트 합산 및 진행
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            // 노드의 값으로 사용할 나머지 계산
            remainder = (sum + carry) % 10;
            // 10으로 나누었을때 몫은 자릿수가 증가했다는 의미이므로 자리올림수로 사용
            carry = (sum + carry) / 10;
            // 나머지는 다음 노드의 값으로 지정
            node.next = new ListNode(remainder);
            // 계산할 노드를 다음으로 이동
            node = node.next;
        }
        // 첫 번째 노드는 임시 노드이므로 그 다음부터 결과로 리턴
        return root.next;
    }
}