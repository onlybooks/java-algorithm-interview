package ch23;

public class P94_2 {
    public int rob(int[] nums) {
        // 입력값이 1개인 경우 예외 처리
        if (nums.length == 1)
            return nums[0];

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);
        // 이전 결과와 (전전 결과 + 현재 결과) 중 큰 값 저장
        for (int i = 2; i < nums.length; i++)
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        // 항상 최댓값이 저장되므로 마지막 값을 정답으로 리턴
        return dp[nums.length - 1];
    }
}
