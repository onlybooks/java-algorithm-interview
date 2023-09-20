package ch24

import kotlin.math.sqrt

class P97_5 {
    // 소수 여부 판별 메소드
    fun isPrime(num: Long): Boolean {
        // 1은 소수가 아니며, 2이상인데 2로 나눠지면 소수가 아니므로 미리 처리
        if (num == 1L || (num > 2 && num % 2 == 0L))
            return false

        // 3부터 차례대로 나눠지는지 확인
        for (i in 3..sqrt(num.toDouble()).toInt() step 2) {
            if (num % i == 0L)
                return false
        }
        return true
    }

    fun solution(n: Int, k: Int): Int {
        // k 진수 문자열로 변환
        val str = n.toString(k)

        // 0을 기준으로 구분하여 각각 소수 여부 처리
        var answer = 0
        for (s in str.split("0").filter { it.isNotEmpty() }) {
            // 소수인 경우 정답 +1
            if (isPrime(s.toLong()))
                answer++
        }
        return answer
    }
}