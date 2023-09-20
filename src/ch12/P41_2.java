package ch12;

import java.util.*;

public class P41_2 {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> fromToMap = new HashMap<>();

        // 여행 일정을 from → to 형태의 그래프로 구성
        for (List<String> ticket : tickets) {
            // 값이 존재하지 않을 경우 빈 우선순위 큐 생성
            fromToMap.putIfAbsent(ticket.get(0), new PriorityQueue<>());
            // 목적지 to 추가, 우선순위 큐이므로 to는 항상 사전 어휘순으로 정렬된다.
            fromToMap.get(ticket.get(0)).add(ticket.get(1));
        }

        List<String> results = new LinkedList<>();
        Deque<String> stack = new ArrayDeque<>();
        // 출발지 삽입
        stack.push("JFK");
        while (!stack.isEmpty()) {
            // 스택에서 추출될 값을 출발지로 한 도착지 처리
            while (fromToMap.containsKey(stack.getFirst()) && !fromToMap.get(stack.getFirst()).isEmpty()) {
                // 여러 도착지 중 사전 어휘순으로 추출해 스택에 삽입
                stack.push(fromToMap.get(stack.getFirst()).poll());
            }

            // 위 반복문이 모두 실행된 이후에는 스택에서 값이 하나씩 추출되어 정답으로 구성된다.
            results.add(0, stack.pop());
        }

        return results;
    }
}
