package ch10

import datatype.ListNode
import java.util.*

class P27_2 {
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        val pq = PriorityQueue<ListNode> { o1, o2 ->
            when {
                // 동일한 값이면 무시
                o1.`val` == o2.`val` -> 0
                // 새로운 값(o1)이 기본 값(o2)보다 크면 뒤에 위치
                o1.`val` > o2.`val` -> 1
                // 작으면 앞에 위치
                else -> -1
            }
        }
        val root = ListNode(0)
        var tail = root

        // 각 연결 리스트의 첫 번째 노드를 큐에 저장
        for (node in lists)
            if (node != null)
                pq.add(node)

        // 큐가 모두 빌때까지 반복
        while (!pq.isEmpty()) {
            // 우선순위에 따라 추출, 다음 노드로 이동
            tail.next = pq.poll()
            tail = tail.next

            // 추출한 연결 리스트의 다음 노드는 다시 큐에 저장
            if (tail.next != null)
                pq.add(tail.next)
        }
        return root.next
    }
}