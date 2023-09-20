package ch23

class P93_3 {
    // 문제 제약 조건에 따라 45에서 1칸 더 크게 지정
    var dp = IntArray(46)

    fun climbStairs(n: Int): Int {
        // 2 이하는 미리 지정한 값 리턴
        if (n <= 2) return n

        // 미리 계산한 결과가 있다면 해당 값 리턴
        if (dp[n] != 0)
            return dp[n]
        dp[n] = climbStairs(n - 1) + climbStairs(n - 2)
        return dp[n]
    }
}