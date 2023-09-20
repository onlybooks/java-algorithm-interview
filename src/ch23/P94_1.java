package ch23;

public class P94_1 {
    public long calc = 0;
    public int rob(int[] nums, int n) {
        calc++;
        if (n < 0)
            return 0;
        // 이전 결과와 (전전 결과 + 현재 결과) 중 큰 값 리턴
        return Math.max(
                rob(nums, n - 1),
                rob(nums, n - 2) + nums[n]
        );
    }

    public int rob(int[] nums) {
        // 피보나치 수열 형태로 계산하여 리턴
        return rob(nums, nums.length - 1);
    }
}

