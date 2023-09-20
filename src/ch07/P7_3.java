package ch07;

import java.util.HashMap;
import java.util.Map;

public class P7_3 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numsMap = new HashMap<>();
        // 하나의 for 반복으로 통합
        for (int i = 0; i < nums.length; i++) {
            // target에서 num을 뺀 값이 있으면 정답으로 리턴
            if (numsMap.containsKey(target - nums[i])) {
                return new int[]{numsMap.get(target - nums[i]), i};
            }
            // 정답이 아니므로 다음번 비교를 위해 인덱스를 맵에 저장
            numsMap.put(nums[i], i);
        }
        // 항상 정답이 존재하므로 널이 리턴되는 경우는 없음
        return null;
    }
}
