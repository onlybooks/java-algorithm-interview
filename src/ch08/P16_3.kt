package ch08

import datatype.ListNode

class P16_3 {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        // 파라미터는 수정할 수 없으므로 var 별도 선언
        var l1var = l1
        var l2var = l2

        // 값을 계산할 임시 노드 선언
        var node = ListNode(0)
        // 임시 노드를 첫 번째 노드로 선언
        val root = node

        // 자릿수의 합(sum), 자리올림수(carry), 나머지(remainder)를 저장할 변수 선언
        var sum: Int
        var carry = 0
        var remainder: Int
        // 모든 연결 리스트를 끝까지 순회하고, 자리올림수도 0이 될때까지 진행
        while (l1var != null || l2var != null || carry != 0) {
            sum = 0
            // 첫 번째 연결 리스트 합산 및 진행
            if (l1var != null) {
                sum += l1var.`val`
                l1var = l1var.next
            }
            // 두 번째 연결 리스트 합산 및 진행
            if (l2var != null) {
                sum += l2var.`val`
                l2var = l2var.next
            }

            // 노드의 값으로 사용할 나머지 계산
            remainder = (sum + carry) % 10
            // 10으로 나누었을 때 몫은 자릿수가 증가했다는 의미이므로 자리올림수로 사용
            carry = (sum + carry) / 10
            // 나머지는 다음 노드의 값으로 지정
            node.next = ListNode(remainder)
            // 계산할 노드를 다음으로 이동
            node = node.next
        }
        // 첫 번째 노드는 임시 노드이므로 그다음부터 결과로 리턴
        return root.next
    }
}