package ch23

class P94_3 {
    fun rob(nums: IntArray): Int {
        // 입력값이 1개인 경우 예외 처리
        if (nums.size == 1)
            return nums[0]

        val dp = IntArray(nums.size)
        dp[0] = nums[0]
        dp[1] = dp[0].coerceAtLeast(nums[1])

        // 이전 결과와 (전전 결과 + 현재 결과) 중 큰 값 저장
        for (i in 2 until nums.size)
            dp[i] = dp[i - 1].coerceAtLeast(dp[i - 2] + nums[i])
        // 항상 최댓값이 저장되므로 마지막 값을 정답으로 리턴
        return dp[nums.size - 1]
    }
}