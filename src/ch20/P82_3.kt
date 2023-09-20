package ch20

class P82_3 {
    fun minWindow(s: String, t: String): String {
        // 필요한 문자의 카운터를 정의하는 맵
        val need: MutableMap<Char, Int> = mutableMapOf()
        // 찾아야 하는 문자열의 모든 문자 삽입, 찾아야 하는 문자는 0 이상의 값이 되며,
        // 나머지 문자는 모두 0 이하의 값이다.
        for (c in t.toCharArray()) {
            need[c] = need.getOrDefault(c, 0) + 1
        }
        // 필요한 문자 전체 카운터 지정
        var missing = t.length
        var left = 0
        var right = 0
        var start = 0
        var end = 0
        var minLen = Int.MAX_VALUE

        // 오른쪽 포인터 이동
        for (c in s.toCharArray()) {
            right++
            // 0보다 큰 값이면 필요했던 값이므로 전체 카운터에서 감소
            if (need.containsKey(c) && need[c]!! > 0) {
                missing--
            }
            // need에서 해당 문자는 카운터 감소
            need[c] = need.getOrDefault(c, 0) - 1

            // 필요한 문자 카운터가 0이면 왼쪽 포인터 이동
            if (missing == 0) {
                // need 값이 0 미만인 경우에는 증가시키며 왼쪽 포인터 계속 이동
                while (left < right && need[s[left]]!! < 0) {
                    need[s[left]] = need.getOrDefault(s[left], 0) + 1
                    left++
                }

                // 찾은 길이가 기존 최소 길이보다 더 작으면 교체
                if (minLen > right - left + 1) {
                    minLen = right - left + 1
                    start = left
                    end = right
                }
                // 마지막에 빠지는 값은 다시 채워야 하는 값이므로 전체 카운터를 증가시키며 왼쪽 포인터 이동
                need[s[left]] = need.getOrDefault(s[left], 0) + 1
                missing++
                left++
            }
        }
        return s.substring(start, end)
    }
}