package ch17

import java.util.*

class P68_2 {
    fun isAnagram(s: String, t: String): Boolean {
        fun sort(s: String): String {
            // 문자열을 문자 배열로 변환
            val chars = s.toCharArray()
            // 문자 배열을 정렬
            Arrays.sort(chars)
            // 문자 배열을 문자열로 만들어 리턴
            return String(chars)
        }
        // s를 정렬한 결과와 t를 정렬한 결과가 일치하는지 비교
        return sort(s) == sort(t)
    }
}