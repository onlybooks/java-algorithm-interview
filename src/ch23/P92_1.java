package ch23;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P92_1 {
    public int maxSubArray(int[] nums) {
        // 첫 번째 값을 초깃값으로 리스트 선언
        List<Integer> sums = new ArrayList<>(List.of(nums[0]));
        for (int i = 1; i < nums.length; i++)
            // 이전까지 합이 0보다 크면 누적 합산
            sums.add(nums[i] + (sums.get(i - 1) > 0 ? sums.get(i - 1) : 0));
        return Collections.max(sums);
    }
}
