package ch06

class P6_2 {
    var left: Int = 0
    var maxLen: Int = 0

    fun extendPalindrome(s: String, j: Int, k: Int) {
        // 파라미터는 수정할 수 없으므로 var 별도 선언
        var l = j
        var r = k
        // 투 포인터가 유효한 범위 내에 있고 양쪽 끝 문자가 일치하는 팰린드롬인 경우 범위 확장
        while (l >= 0 && r < s.length && s[l] == s[r]) {
            l--
            r++
        }

        // 기존 최대 길이보다 큰 경우 값 교체
        if (maxLen < r - l - 1) {
            left = l + 1
            maxLen = r - l - 1
        }
    }

    fun longestPalindrome(s: String): String? {
        // 문자 길이 저장
        val len = s.length

        // 길이가 1인 경우 예외 처리
        if (len < 2) return s

        // 우측으로 한 칸씩 이동하며 투 포인터 조사
        for (i in 0 until len - 1) {
            extendPalindrome(s, i, i + 1) // 2칸짜리 투 포인터
            extendPalindrome(s, i, i + 2) // 3칸짜리 투 포인터
        }
        // 왼쪽과 최대 길이만큼을 더한 오른쪽 만큼의 문자를 정답으로 리턴
        return s.substring(left, left + maxLen)
    }
}