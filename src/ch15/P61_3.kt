package ch15

import java.util.*

class P61_3 {
    fun solution(operations: Array<String>): IntArray {
        // 우선순위 큐 선언, 자바 기본은 최소 힙이므로 최대 힙으로 정렬 지정
        val minHeap: Queue<Int> = PriorityQueue()
        val maxHeap: Queue<Int> = PriorityQueue(Collections.reverseOrder())

        // 명령어 목록을 하나씩 순회하면서 해당하는 작업 수행
        operations
            .map { it.split(" ") }
            .forEach { op ->
                // 삽입 연산
                when (op[0]) {
                    "I" -> { // 추출 연산
                        minHeap.add(Integer.valueOf(op[1]))
                        maxHeap.add(Integer.valueOf(op[1]))
                    }

                    "D" -> { // 삭제 연산
                        when (op[1]) {
                            // 값이 1인 경우 최댓값 추출
                            "1" -> minHeap.remove(maxHeap.poll())
                            // 값이 -1인 경우 최솟값 추출
                            "-1" -> maxHeap.remove(minHeap.poll())
                        }
                    }
                }
            }

        // 최종결과인 최댓값과 최솟값을 추출하고 값이 없다면 0, 아니라면 해당 값으로 리턴
        return intArrayOf(
            maxHeap.poll() ?: 0,
            minHeap.poll() ?: 0
        )
    }
}