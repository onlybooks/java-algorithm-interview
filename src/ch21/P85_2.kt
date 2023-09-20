package ch21

import java.util.*

class P85_2 {
    fun reconstructQueue(people: Array<IntArray>): Array<IntArray> {
        // 우선순위 큐 선언, 정렬 기준은 큰 키 우선, 값이 같다면 앞에 줄 서 있는 사람이 작은 순으로
        val pq: Queue<IntArray> = PriorityQueue { a: IntArray, b: IntArray ->
            if (a[0] != b[0])
                b[0] - a[0]
            else
                a[1] - b[1]
        }

        // 우선순위 큐에 배열 입력값 삽입
        for (person in people)
            pq.add(person)

        val result: MutableList<IntArray> = mutableListOf()
        // 우선순위 큐에서 모두 추출할 때까지 반복
        while (!pq.isEmpty()) {
            // 큰 키 우선, 앞에 줄 서 있는 사람이 작은 순으로 추출
            val person = pq.poll()
            // 앞에 줄 서 있는 사람을 인덱스로 정해서 삽입
            result.add(person[1], person)
        }
        // 최종 결과 자료형에 맞게 변환하여 리턴
        return result.toTypedArray()
    }
}