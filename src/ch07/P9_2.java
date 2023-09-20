package ch07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P9_2 {
    public List<List<Integer>> threeSum(int[] nums) {
        int left, right, sum;
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            // 중복된 값 건너뛰기
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            // 간격을 좁혀가며 합 sum 계산
            left = i + 1;
            right = nums.length - 1;
            while (left < right) {
                sum = nums[i] + nums[left] + nums[right];
                // 합이 0보다 작다면 왼쪽 포인터 이동
                if (sum < 0)
                    left += 1;
                // 합이 0보다 크다면 오른쪽 포인터 이동
                else if (sum > 0)
                    right -= 1;
                else {
                    // sum=0인 경우이므로 정답 처리
                    results.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // 중복된 값 건너뛰기, 이 처리를 하지 않으면 같은 정답이 두 번 나올 수 있다.
                    while (left < right && nums[left] == nums[left + 1])
                        left += 1;
                    while (left < right && nums[right] == nums[right - 1])
                        right -= 1;
                    // 정답이 나왔으므로 투 포인터 모두 한칸씩 이동. sum=0인 상황이므로 양쪽 모두 이동해야 한다.
                    left += 1;
                    right -= 1;
                }
            }
        }
        return results;
    }
}
