package ch08;

import datatype.ListNode;
import java.util.Stack;

public class P13_1 {
    public boolean isPalindrome(ListNode head) {
        // 주의: 스택을 이렇게 선언하면 안됨
        Stack<Integer> stack = new Stack<>();
        // 연결 리스트를 스택에 삽입
        ListNode node = head;
        while (node != null) {
            stack.add(node.val);
            node = node.next;
        }

        // 연결 리스트가 모두 빌때까지 비교
        while (head != null) {
            // 연결 리스트와 스택에서 추출한 값을 비교해 팰린드롬 판별
            if (head.val != stack.pop()) {
                return false;
            }
            head = head.next;
        }
        return true;
    }
}
