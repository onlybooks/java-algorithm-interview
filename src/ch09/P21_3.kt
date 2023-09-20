package ch09

import java.util.*

class P21_3 {
    fun removeDuplicateLetters(s: String): String {
        // 문자 개수를 계산해서 담아둘 변수 선언
        val counter: MutableMap<Char, Int> = mutableMapOf()
        // 이미 처리한 문자 여부를 확인하기 위한 변수 선언
        val seen: MutableMap<Char, Boolean> = mutableMapOf()
        // 문제 풀이에 사용할 스택 선언
        val stack: Deque<Char> = ArrayDeque()

        // 문자별 개수 계산
        for (c in s)
            counter[c] = counter.getOrDefault(c, 0) + 1

        for (c in s) {
            // 현재 처리하는 문자는 카운터에서 -1 처리
            counter[c] = counter[c]!! - 1
            // 이미 처리한 문자는 건너뛴다.
            if (seen[c] == true)
                continue

            // 스택에 있는 문자가 현재 문자보다 더 뒤에 붙여야 할 문자라면 스택에서 제거하고 처리하지 않은 걸로 표시
            while (!stack.isEmpty() && stack.peek() > c && counter[stack.peek()]!! > 0)
                seen[stack.pop()] = false
            // 현재 문자를 스택에 삽입
            stack.push(c)
            // 현재 문자를 처리한 걸로 선언
            seen[c] = true
        }

        // 스택에 있는 문자를 큐 순서대로 추출하여 리턴
        val sb = StringBuilder()
        while (!stack.isEmpty())
            sb.append(stack.pollLast())
        return sb.toString()
    }
}