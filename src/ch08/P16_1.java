package ch08;

import datatype.ListNode;

import java.math.BigInteger;

public class P16_1 {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null, node = head;
        // 노드 끝으로 이동할 때까지 순회
        while (node != null) {
            // 현재 노드의 다음 노드 미리 지정
            ListNode next = node.next;
            // 현재 노드의 다음으로 이전 노드 지정
            node.next = prev;
            // 이전 노드는 현재 노드로 지정
            prev = node;
            // 미리 지정했던 다음 노드를 현재 노드로 변경
            node = next;
        }
        // prev는 뒤집힌 연결 리스트의 첫 번째 노드
        return prev;
    }

    // 연결 리스트를 임의 정밀도 정수형으로 변환
    public BigInteger toBigInt(ListNode node) {
        String val = "";
        // 연결 리스트를 순회하며 한 글자씩 조합
        while (node != null) {
            val += node.val;
            node = node.next;
        }
        // 조합한 글자를 임의 정밀도 정수형으로 변환
        return new BigInteger(val);
    }

    // 임의 정밀도 정수형을 연결 리스트로 변환
    public ListNode toReversedLinkedList(BigInteger val) {
        ListNode prev = null, node = null;
        // 정수형을 문자로 바꾼 다음 문자 배열로 전환하여 한 글자씩 순회
        for (char c : String.valueOf(val).toCharArray()) {
            // 한 글자씩 숫자로 변환하여 노드 지정
            node = new ListNode(Character.getNumericValue(c));
            // 최종 결과는 뒤집어야 하므로 현재 노드의 다음으로 이전 노드 지정
            node.next = prev;
            // 이전 노드는 현재 노드로 지정
            prev = node;
        }
        return node;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 2개의 연결 리스트를 뒤집는다
        ListNode l1Reversed = reverseList(l1);
        ListNode l2Reversed = reverseList(l2);

        // 임의 정밀도 정수형으로 변환하여 더하기 연산 진행
        BigInteger result = toBigInt(l1Reversed).add(toBigInt(l2Reversed));
        // 결과를 다시 역순 연결 리스트로 변환
        return toReversedLinkedList(result);
    }
}
