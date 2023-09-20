package ch15;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class P61_1 {
    public int[] solution(String[] operations) {
        // 우선순위 큐 선언, 자바 기본은 최소 힙이므로 최대 힙으로 정렬 지정
        Queue<Integer> minHeap = new PriorityQueue<>();
        Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // 명령어 목록을 하나씩 순회하면서 해당하는 작업 수행
        for (String operation : operations) {
            // 띄어쓰기를 기준으로 명령과 값 분리
            String[] op = operation.split(" ");
            // 삽입 연산
            if ("I".equals(op[0])) {
                minHeap.add(Integer.valueOf(op[1]));
                maxHeap.add(Integer.valueOf(op[1]));
            // 추출 연산
            } else if ("D".equals(op[0])) {
                // 값이 1인 경우 최댓값 추출
                if ("1".equals(op[1])) {
                    minHeap.remove(maxHeap.poll());
                // 값이 -1인 경우 최솟값 추출
                } else if ("-1".equals(op[1])) {
                    maxHeap.remove(minHeap.poll());
                }
            }
        }

        // 최종결과인 최댓값과 최솟값 추출
        Integer maxValue = maxHeap.poll();
        Integer minValue = minHeap.poll();

        // 값이 없다면 0, 아니라면 해당 값으로 리턴
        return new int[]{
                (maxValue == null) ? 0 : maxValue,
                (minValue == null) ? 0 : minValue};
    }
}
