package ch23

class P91_5 {
    // 문제 제약 조건에 따라 30에서 1칸 더 크게 지정
    var dp = IntArray(31)

    fun fib(n: Int): Int {
        // 0과 1인 상향식과 마찬가지로 값을 미리 지정
        if (n <= 1) return n

        // 미리 계산한 결과가 있다면 해당 값 리턴
        if (dp[n] != 0)
            return dp[n]
        dp[n] = fib(n - 1) + fib(n - 2)
        return dp[n]
    }
}