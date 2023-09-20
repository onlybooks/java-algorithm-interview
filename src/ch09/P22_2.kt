package ch09

import java.util.*

class P22_2 {
    fun dailyTemperatures(temperatures: IntArray): IntArray {
        // 결과를 담을 정수형 배열 선언
        val result = IntArray(temperatures.size)
        // 결과 처리를 위한 스택 선언
        val stack: Deque<Int> = ArrayDeque()
        for (i in temperatures.indices) {
            // 현재 온도가 스택에 있는 온도보다 높다면 꺼내서 결과를 업데이트한다.
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                val last = stack.pop()
                // 결과 업데이트
                result[last] = i - last
            }
            // 현재 인덱스를 스택에 삽입
            stack.push(i)
        }
        return result
    }
}