package ch17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class P65_1 {
    public int[][] merge(int[][] intervals) {
        List<int[]> merged = new ArrayList<>();
        // 첫 번째 값을 기준으로 입력값 정렬
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        // 정렬된 결과 순회
        for (int[] i : intervals) {
            // 순회 결과가 기존 병합 결과보다 작다면 겹치는 경우이므로, 두 번째 값을 기준으로 확장
            if (!merged.isEmpty() && i[0] <= merged.get(merged.size() - 1)[1]) {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], i[1]);
            } else {
                // 겹치지 않는 경우 결과 단순 삽입
                merged.add(i);
            }
        }
        // 최종 결과 자료형에 맞게 변환하여 리턴
        return merged.toArray(new int[merged.size()][]);
    }
}