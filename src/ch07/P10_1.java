package ch07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class P10_1 {
    public int arrayPairSum(int[] nums) {
        int sum = 0;
        List<Integer> pair = new ArrayList<>();
        Arrays.sort(nums);

        // 앞에서부터 오름차순으로 반복
        for (int n : nums) {
            pair.add(n);
            // 페어 변수에 값이 2개 채워지면 min()을 합산하고 변수 초기화
            if (pair.size() == 2) {
                sum += Collections.min(pair);
                pair.clear();
            }
        }
        return sum;
    }
}
