package ch23;

public class P92_3 {
    public int maxSubArray(int[] nums) {
        int currentSum = 0;
        int bestSum = Integer.MIN_VALUE;
        for (int num : nums) {
            // 현재 값과 (누적된 값 + 현재 값) 중 더 큰 값을 저장
            currentSum = Math.max(num, currentSum + num);
            // 매번 최댓값을 계산하여 저장
            bestSum = Math.max(bestSum, currentSum);
        }
        return bestSum;
    }
}
