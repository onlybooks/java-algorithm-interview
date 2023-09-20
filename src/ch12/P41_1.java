package ch12;

import java.util.*;

public class P41_1 {
    public void dfs(List<String> results, Map<String, PriorityQueue<String>> fromToMap, String from) {
        // from → to 값이 존재하는 경우 반복해서 재귀 DFS
        while (fromToMap.containsKey(from) && !fromToMap.get(from).isEmpty()) {
            // 사전 어휘순 첫 위치부터 우선순위 큐를 이용해 추출 및 재귀 DFS 진행
            dfs(results, fromToMap, fromToMap.get(from).poll());
        }
        // 재귀 DFS가 모두 끝났다면 최종 위치는 도착지이므로 결과를 출발지까지 앞으로 삽입한다.
        results.add(0, from);
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> results = new LinkedList<>();
        Map<String, PriorityQueue<String>> fromToMap = new HashMap<>();

        // 여행 일정을 from → to 형태의 그래프로 구성
        for (List<String> ticket : tickets) {
            // 값이 존재하지 않을 경우 빈 우선순위 큐 생성
            fromToMap.putIfAbsent(ticket.get(0), new PriorityQueue<>());
            // 목적지 to 추가, 우선순위 큐이므로 to는 항상 사전 어휘순으로 정렬된다.
            fromToMap.get(ticket.get(0)).add(ticket.get(1));
        }
        // 재귀 DFS 시작
        dfs(results, fromToMap, "JFK");

        return results;
    }
}
