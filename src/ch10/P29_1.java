package ch10;

import java.util.PriorityQueue;

public class P29_1 {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        // 차례대로 추출하기 위해 우선순위 큐에 모두 삽입
        for (int s : scoville) {
            pq.add(s);
        }

        int answer = 0;
        while (pq.size() >= 2) {
            // 가장 안 매운 음식이 K 이상이면 정답 리턴
            if (pq.peek() >= K)
                return answer;
            // 두 음식을 섞어서 새로운 음식을 만들어 삽입
            pq.add(pq.poll() + (pq.poll() * 2));
            answer++;
        }
        // 모두 섞었음에도 K를 넘지 않는다면 -1 리턴
        if (pq.peek() < K)
            return -1;
        return answer;
    }
}
