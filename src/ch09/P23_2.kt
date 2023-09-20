package ch09

import java.util.*

class P23_2 {
    // 큐 변수, 구현체는 LinkedList로 선언
    val queue: Queue<Int> = LinkedList()

    fun push(x: Int) {
        // 엘리먼트 삽입
        queue.add(x)
        // 맨 앞에 두는 상태로 전체 재정렬
        for (i in 1 until queue.size)
            queue.add(queue.remove())
    }

    fun pop(): Int {
        // 재정렬한 상태이므로 큐 연산으로 추출
        return queue.remove()
    }

    fun top(): Int {
        // 재정렬한 상태이므로 큐 연산으로 조회
        return queue.peek()
    }

    fun empty(): Boolean {
        // 크기를 비교해 비어있는지 확인
        return queue.size == 0
    }
}