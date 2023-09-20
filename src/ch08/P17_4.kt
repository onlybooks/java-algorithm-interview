package ch08

import datatype.ListNode

class P17_4 {
    fun swapPairs(head: ListNode?): ListNode? {
        // 현재 노드와 다음 노드가 있으면 반복
        if (head?.next != null) {
            // 다음 노드 선언
            val p = head.next
            // 다음 다음 노드를 파라미터로 전달하고 스왑된 값을 리턴 받음
            head.next = swapPairs(head.next.next)
            // 다음 다음 노드는 현재 노드로 지정
            p.next = head
            // 다음 노드 리턴
            return p
        }
        return head
    }
}