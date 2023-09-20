package ch17

import datatype.ListNode

class P66_3 {
    fun insertionSortList(head: ListNode?): ListNode? {
        // 코틀린은 함수의 파라미터를 수정할 수 없기 때문에 별도의 변수로 선언
        var node = head
        // 루트를 가리키는 변수 선언, 나중에 parent.next를 결과로 리턴
        val parent = ListNode()
        // 정렬을 끝낸 대상을 가리키는 포인터
        var p = parent

        // 다음 노드가 없을 때 까지 끝까지 순회
        while (node != null) {
            // 정렬을 끝낸 포인터(p)의 다음 값이 정렬을 해야 할 대상(head)보다 작다면 계속 이동
            while (p.next != null && p.next.`val` < node.`val`)
                p = p.next

            // 서로 위치를 교환하고 정렬을 해야할 대상(head)은 다음 노드로 이동
            val pNext = p.next
            val headNext = node.next
            p.next = node
            node.next = pNext
            node = headNext
            // 정렬을 끝낸 포인터(p)의 값이 다음번 정렬을 해야 할 대상(head)보다 클때만 포인터 맨 앞으로 이동
            if (node != null && p.`val` > node.`val`)
                p = parent
        }
        return parent.next
    }
}