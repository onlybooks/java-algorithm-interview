package ch11

import kotlin.math.max

class P32_2 {
    fun lengthOfLongestSubstring(s: String): Int {
        val used: MutableMap<Char, Int> = mutableMapOf()
        var maxLength = 0
        var left = 0
        var right = 0
        // 문자열을 문자 단위로 반복
        for (c in s.toCharArray()) {
            // 이미 등장했던 문자이고, 슬라이딩 윈도우의 안쪽에 있다면 left 위치 업데이트
            if (left <= used.getOrDefault(c, -1)) {
                left = used[c]!! + 1
            } else { // 최대 부분 문자열 길이 업데이트
                maxLength = max(maxLength, right - left + 1)
            }

            // 현재 문자의 위치 삽입
            used[c] = right
            // 오른쪽 포인터 right는 현재 문자의 위치에 맞춰 계속 증가
            right++
        }
        return maxLength
    }
}