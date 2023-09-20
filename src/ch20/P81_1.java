package ch20;

import java.util.ArrayList;
import java.util.List;

public class P81_1 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // 예외 처리
        if (nums.length == 0)
            return new int[0];

        List<Integer> result = new ArrayList<>();
        // 배열 전체를 순회하며 슬라이드 윈도우별 최댓값을 구한다.
        for (int i = 0; i < nums.length - k + 1; i++) {
            // 첫 번째 값을 최댓값으로 임시 선언
            int max = nums[i];
            // k 크기만큼 순회하며 최댓값 구하기
            for (int j = i + 1; j < i + k; j++) {
                if (nums[j] > max)
                    max = nums[j];
            }
            result.add(max);
        }
        // List<Integer> → int[] 변환하여 리턴
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
