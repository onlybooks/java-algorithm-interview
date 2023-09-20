package ch10

import java.util.*

class P28_3 {
    // 거리와 좌표를 보관할 Point 클래스 선언
    data class Point(var distance: Long, var point: IntArray)

    fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> {
        // Point 클래스를 저장하는 우선순위 큐로, 정렬 기준은 distance로 한다.
        val pq: Queue<Point> = PriorityQueue(compareBy { a -> a.distance })

        // 파라미터로 받은 좌표 목록 순회
        for (point in points) {
            // 유클리드 거리 계산
            val distance = point[0].toLong() * point[0] + point[1].toLong() * point[1]
            // 우선순위 큐에 거리와 좌표를 Point 클래스로 담아 삽입
            pq.add(Point(distance, point))
        }

        // 결과 변수 선언
        val results: Array<IntArray> = Array(k) { IntArray(2) { 0 } }
        // k번만큼 반복하여 결과 추출
        for (i in 0 until k) {
            // 우선순위 큐에서 추출한 Point 클래스의 좌표(point)를 결과로 삽입
            results[i] = pq.poll().point
        }
        return results
    }
}