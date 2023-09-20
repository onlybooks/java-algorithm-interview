package ch08;

import datatype.ListNode;

import java.util.Deque;
import java.util.LinkedList;

public class P13_2 {
    public boolean isPalindrome(ListNode head) {
        Deque<Integer> deque = new LinkedList<>();
        // 연결 리스트를 데크에 삽입
        ListNode node = head;
        while (node != null) {
            deque.add(node.val);
            node = node.next;
        }

        // 데크가 모두 비거나(짝수 개일 때) 1개 이하(홀수 개일 때)가 될 때까지 비교
        while (!deque.isEmpty() && deque.size() > 1) {
            // 데크의 양끝을 추출해 팰린드롬 여부 확인
            if (deque.pollFirst() != deque.pollLast()) {
                return false;
            }
        }
        return true;
    }
}
