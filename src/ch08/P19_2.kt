package ch08

import datatype.ListNode

class P19_2 {
    fun reverseBetween(head: ListNode?, left: Int, right: Int): ListNode? {
        // 예외 처리
        if (head == null)
            return null
        // 임시 노드 선언
        val root = ListNode(0)
        // 임시 노드 다음으로 노드 시작
        root.next = head
        // 임시 노드부터 시작해 변경 필요한 위치 앞으로 이동
        var start = root
        for (i in 0 until left - 1)
            start = start.next
        // 변경이 필요한 마지막 위치 선언
        val end = start.next
        // right - left만큼 위치 변경 진행
        for (i in 0 until right - left) {
            val tmp = start.next
            start.next = end.next
            end.next = end.next.next
            start.next.next = tmp
        }
        // 첫 번째 노드는 임시 노드이므로 그 다음부터 결과로 리턴
        return root.next
    }
}