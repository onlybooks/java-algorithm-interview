package ch24;

import java.util.*;

public class P100_1 {
    // from → to 그래프
    Map<Integer, List<Integer>> graph = new HashMap<>();
    int answer = 1;

    static class Node {
        int index;
        int sheep;
        int wolves;
        List<Integer> nodes;

        Node(int index, int sheep, int wolves, List<Integer> nodes) {
            this.index = index;
            this.sheep = sheep;
            this.wolves = wolves;
            this.nodes = nodes;
        }
    }

    public int solution(int[] info, int[][] edges) {
        // from → to 그래프 구성
        for (int[] edge : edges) {
            graph.putIfAbsent(edge[0], new ArrayList<>());
            graph.get(edge[0]).add(edge[1]);
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0, 1, 0, graph.get(0)));

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            // 해당 노드에서 진행 가능 노드 모두 탐색
            for (int nextNode : node.nodes) {
                int nextSheep = (info[nextNode] == 0) ? node.sheep + 1 : node.sheep;
                int nextWolves = (info[nextNode] == 1) ? node.wolves + 1 : node.wolves;

                // 다음 노드에 방문이 가능하다면 처리 및 큐 삽입
                if (nextSheep > nextWolves) {
                    // 최댓값이면 교체
                    answer = Math.max(answer, nextSheep);

                    // 동일한 값을 참조하지 않기 위해 새롭게 생성해서 부여
                    List<Integer> candidateNodes = new ArrayList<>(node.nodes);
                    // 현재 처리 중 노드는 값을 찾아서 삭제, 타입을 지정해야 값을 삭제함
                    candidateNodes.remove((Integer) nextNode);
                    // 방문 가능한 노드 추가
                    if (graph.get(nextNode) != null)
                        candidateNodes.addAll(graph.get(nextNode));

                    // 큐 삽입(BFS)
                    queue.offer(new Node(nextNode, nextSheep, nextWolves, candidateNodes));
                }
            }
        }
        return answer;
    }
}
