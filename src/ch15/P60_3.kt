package ch15

import java.util.*

class P60_3 {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        // 우선순위 큐 선언, 자바 기본은 최소 힙이므로 최대 힙으로 정렬 지정
        val pq: Queue<Int> = PriorityQueue(Collections.reverseOrder())

        // 입력값을 모두 힙에 삽입한다.
        for (n in nums)
            pq.add(n)

        // k - 1만큼 힙에서 추출한다.
        for (i in 0 until k - 1)
            pq.poll()

        // k번째 마지막 값을 정답으로 리턴
        return pq.poll()
    }
}