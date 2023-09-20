package ch20;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P81_2 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        // 윈도우 값이 저장될 큐
        Queue<Integer> window = new LinkedList<>();
        // 최댓값의 초깃값은 가장 작은 값으로 설정
        int currentMax = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            // 윈도우 데크에 삽입
            window.add(nums[i]);
            // 현재 위치가 슬라이딩 윈도우 크기 안에 있다면 스킵
            if (i < k - 1)
                continue;
            // 최댓값이 초깃값이라면 최댓값 다시 설정
            if (currentMax == Integer.MIN_VALUE) {
                // 자바 8+ 스트림 이용 데크의 최댓값 얻기
                currentMax = window.stream().max(Integer::compareTo).get();
            } else if (currentMax < nums[i]) {
                // 현재 값이 기존 최댓값보다 크다면 교체
                currentMax = nums[i];
            }
            // 최댓값을 정답으로 추가
            result.add(currentMax);
            // 큐에서 가장 오래된 값을 삭제하면서, 최댓값이 큐에서 빠진다면 다음번에 다시 구해야 하므로 최댓값 초기화
            if (currentMax == window.poll())
                currentMax = Integer.MIN_VALUE;
        }
        // List<Integer> → int[] 변환하여 리턴
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
