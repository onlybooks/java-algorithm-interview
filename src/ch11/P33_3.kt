package ch11

import java.util.*

class P33_3 {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        // 각 엘리먼트의 빈도수를 저장할 해시맵 선언, 엘리먼트=>빈도수
        val frequencyMap: MutableMap<Int, Int> = mutableMapOf()
        // 각 엘리먼트의 빈도수를 반복하며 계산하여 저장
        for (n in nums) {
            // 처음 빈도수를 계산하는 엘리먼트는 기본값 0으로, 모두 +1 하여 저장
            frequencyMap[n] = frequencyMap.getOrDefault(n, 0) + 1
        }

        // 빈도순으로 정렬되는 우선순위 큐 선언
        val pq: PriorityQueue<IntArray> = PriorityQueue { a: IntArray, b: IntArray ->
            b[1] - a[1]
        }
        // 우선순위 큐에 각 엘리먼트와 빈도수 삽입
        for (elem in frequencyMap.keys) {
            pq.add(intArrayOf(elem, frequencyMap[elem]!!))
        }

        // 결과로 리턴할 변수 선언
        val result = IntArray(k)
        // k번까지만 반복하여 우선순위 큐에서 결과 추출
        for (i in 0 until k) {
            result[i] = pq.poll()[0]
        }
        return result
    }
}