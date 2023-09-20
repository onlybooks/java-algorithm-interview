package ch09

import java.util.*

class P20_2 {
    fun isValid(s: String): Boolean {
        // 유효성 검증을 위한 스택 선언
        val stack: Deque<Char> = ArrayDeque()
        // 유효성 검증을 위한 매핑 테이블
        val table: MutableMap<Char,Char> = mutableMapOf(
            ')' to '(',
            '}' to '{',
            ']' to '['
        )

        // 문자열을 문자 단위로 반복
        for (i in s.indices) {
            // 닫힘 괄호가 아닌 경우 스택에 푸시
            if (!table.containsKey(s[i])) {
                stack.push(s[i])
            // 중간에 스택이 비거나 팝 결과가 열림 괄호가 아닌 경우 유효하지 않음
            } else if (stack.isEmpty() || table[s[i]] !== stack.pop()) {
                return false
            }
        }
        // 유효한 입력이 되려면 반복 완료 후 스택이 비어야 한다.
        return stack.size == 0
    }
}