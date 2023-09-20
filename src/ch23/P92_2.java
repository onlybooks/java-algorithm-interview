package ch23;

import java.util.Arrays;

public class P92_2 {
    public int maxSubArray(int[] nums) {
        for (int i = 1; i < nums.length; i++)
            // 이전까지 합이 0보다 크면 누적 합산
            nums[i] += (nums[i - 1] > 0) ? nums[i - 1] : 0;
        // 최댓값을 자바 8+ 스트림으로 계산하여 리턴
        return Arrays.stream(nums).max().getAsInt();
    }
}
