package ch14;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P54_1 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        // 예외 처리
        if (n == 1) return List.of(0);

        // 트리 그래프 변수
        Map<Integer, List<Integer>> graph = new HashMap<>();
        // 트리 구조를 양방향 그래프로 구성
        for (int[] edge : edges) {
            // 값이 존재하지 않을 경우 빈 리스트 생성
            graph.putIfAbsent(edge[0], new ArrayList<>());
            graph.putIfAbsent(edge[1], new ArrayList<>());
            // 양방향으로 구성
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        // 첫 번째 리프 노드 추가
        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; i++)
            // 연결이 하나인 노드를 리프 노드로 추가
            if (graph.get(i).size() == 1) leaves.add(i);

        // 루트 노드(2개 이하)만 남을 때까지 반복 제거
        while (n > 2) {
            // 이전 단계 리프 노드 개수만큼 n에서 제거
            n -= leaves.size();
            // 단계별로 새롭게 리프 노드 변수 선언
            List<Integer> newLeaves = new ArrayList<>();
            for (int leaf : leaves) {
                // 리프 노드의 이웃 노드 추출
                int neighbor = graph.get(leaf).get(0);
                // 이웃 노드에서 리프 노드까지 연결 삭제
                graph.get(neighbor).remove((Object) leaf);
                // 이웃 노드가 리프 노드인 경우 newLeaves에 추가
                if (graph.get(neighbor).size() == 1) newLeaves.add(neighbor);
            }
            // 현재 단계에서 리프 노드를 모두 추가한 newLeaves → leaves
            leaves = newLeaves;
        }
        // 2개 이하가 남은 최종 결과 리턴
        return leaves;
    }
}
