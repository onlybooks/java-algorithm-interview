package ch20;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class P81_3 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        // 인덱스를 저장하는 데크 선언
        Deque<Integer> dq = new ArrayDeque<>();

        // 배열 전체 순회
        for (int i = 0; i < nums.length; i++) {
            // 데크 맨 앞이 윈도우 바깥에 있다면 삭제
            if (!dq.isEmpty() && dq.peek() < i - k + 1)
                dq.poll();
            // 현재 값보다 작으면 데크에서 모두 삭제, 데크에는 현재 값보다 큰 인덱스만 남는다.
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i])
                dq.pollLast();
            // 데크에 현재 인덱스 추가
            dq.add(i);
            // 데크의 첫 번째 값은 가장 큰 값이므로 정답으로 추가
            if (i >= k - 1)
                result.add(nums[dq.peek()]);
        }
        // List<Integer> → int[] 변환하여 리턴
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
