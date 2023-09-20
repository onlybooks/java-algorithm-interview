package ch18;

import java.util.Arrays;

public class P75_1 {
    public long solution(int n, int[] times) {
        long answer = 0;

        long left = 1;
        // 맨 오른쪽은 (입력값 중 가장 큰 값 * n)을 가능한 최댓값으로 설정
        long right = (long) Arrays.stream(times).max().getAsInt() * n;
        // 초기 중앙값은 맨 오른쪽 값으로 설정
        long mid = right;

        while (left <= right) {
            long calcN = 0;
            // 소요 시간(중앙값)을 각 심사관의 시간으로 나누고 합산한 값 계산
            for (long time : times)
                calcN += (mid / time);

            // 합산값이 기다리는 사람 수보다 더 크거나 일치하면 중앙값(소요 시간)을 정답으로 설정
            if (calcN >= n) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
            // 중앙값 계산
            mid = left + (right - left) / 2;
        }
        return answer;
    }
}
