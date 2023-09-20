package ch07;

import java.util.Arrays;

public class P10_2 {
    public int arrayPairSum(int[] nums) {
        int sum = 0;
        Arrays.sort(nums);

        // 앞에서부터 오름차순으로 인덱스 반복
        for (int i = 0; i < nums.length; i++) {
            // 짝수 번째일때 값의 합 계산
            if (i % 2 == 0)
                sum += nums[i];
        }
        return sum;
    }
}
