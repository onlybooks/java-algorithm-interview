package ch17

import kotlin.math.max

class P65_2 {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        val merged: MutableList<IntArray> = mutableListOf()
        // 첫 번째 값을 기준으로 입력값 정렬
        intervals.sortWith(Comparator { a: IntArray, b: IntArray -> a[0] - b[0] })

        // 정렬된 결과 순회
        for (i in intervals) {
            // 순회 결과가 기존 병합 결과보다 작다면 겹치는 경우이므로, 두 번째 값을 기준으로 확장
            if (merged.isNotEmpty() && i[0] <= merged[merged.size - 1][1]) {
                merged[merged.size - 1][1] = max(merged[merged.size - 1][1], i[1])
            } else {
                // 겹치지 않는 경우 결과 단순 삽입
                merged.add(i)
            }
        }
        // 최종 결과 자료형에 맞게 변환하여 리턴
        return merged.toTypedArray()
    }
}