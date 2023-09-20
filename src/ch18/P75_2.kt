package ch18

import java.util.*

class P75_2 {
    fun solution(n: Int, times: IntArray): Long {
        var answer: Long = 0

        var left: Long = 1
        // 맨 오른쪽은 (입력값 중 가장 큰 값 * n)을 가능한 최댓값으로 설정
        var right = Arrays.stream(times).max().asInt.toLong() * n
        // 초기 중앙값은 맨 오른쪽 값으로 설정
        var mid = right

        while (left <= right) {
            var calcN: Long = 0
            // 소요 시간(중앙값)을 각 심사관의 시간으로 나누고 합산한 값 계산
            for (time in times)
                calcN += mid / time

            // 합산값이 기다리는 사람 수보다 더 크거나 일치하면 중앙값(소요 시간)을 정답으로 설정
            when {
                calcN >= n -> {
                    answer = mid
                    right = mid - 1
                }
                else -> left = mid + 1
            }
            // 중앙값 계산
            mid = left + (right - left) / 2
        }
        return answer
    }
}