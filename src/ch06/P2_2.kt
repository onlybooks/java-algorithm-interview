package ch06

class P2_2 {
    fun reverseString(s: CharArray): Unit {
        var start = 0
        var end = s.size - 1
        // 서로 중앙으로 이동해 나가다 겹치는 지점에 도달하면 종료
        while (start < end) {
            // also를 이용해 우아하게 스왑
            s[start] = s[end].also { s[end] = s[start] }

            // 앞쪽 문자는 한 칸 뒤로, 뒤쪽 문자는 한 칸 앞으로 이동
            start++
            end--
        }
    }
}