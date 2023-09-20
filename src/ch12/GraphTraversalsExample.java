package ch12;


import java.util.*;

public class GraphTraversalsExample {
    static Map<Integer, List<Integer>> graph = new HashMap<>();

    public static List<Integer> recursiveDFS(int v, List<Integer> discovered) {
        // 현재 노드 저장(전위 순회)
        discovered.add(v);
        // 주변 노드 반복
        for (Integer w : graph.get(v)) {
            // 아직 처리되지 않은 노드라면 깊이 기반 탐색 진행
            if (!discovered.contains(w)) {
                discovered = recursiveDFS(w, discovered);
            }
        }
        // 모든 깊이를 탐색하면 리턴
        return discovered;
    }

    public static List<Integer> iterativeDFS(int v) {
        // 결과 노드를 저장할 리스트 선언
        List<Integer> discovered = new ArrayList<>();
        // 스택 선언은 효율적인 ArrayDeque 자료형 사용
        Deque<Integer> stack = new ArrayDeque<>();
        // 현재 노드를 스택에 삽입
        stack.push(v);
        // 스택이 모두 비워질 때까지 반복
        while (!stack.isEmpty()) {
            // 스택에서 추출
            v = stack.pop();
            // 이미 방문한 노드가 아니라면 방문 노드에 추가하고 주변 노드를 모두 스택에 삽입
            if (!discovered.contains(v)) {
                discovered.add(v);
                // 현재 노드에서 연결된 모든 주변 노드를 스택에 삽입
                for (int w : graph.get(v)) {
                    stack.push(w);
                }
            }
        }
        // 더 이상 탐색할 노드가 없으면 리턴
        return discovered;
    }

    public static List<Integer> iterativeBFS(int start_v) {
        // 결과 노드를 저장할 리스트 선언
        List<Integer> discovered = new ArrayList<>();
        // 시작 노드 삽입
        discovered.add(start_v);
        // 큐는 인터페이스이며 자료형 선언은 LinkedList 사용
        Queue<Integer> queue = new LinkedList<>();
        // 시작 노드 삽입
        queue.add(start_v);
        // 큐가 모두 비워질 때까지 반복
        while (!queue.isEmpty()) {
            // 큐에서 추출
            int v = queue.poll();
            // 현재 노드에서 연결된 모든 주변 노드를 큐에 삽입
            for (int w : graph.get(v)) {
                // 이미 방문한 노드가 아니라면 방문 노드에 추가하고 주변 노드를 모두 큐에 삽입
                if (!discovered.contains(w)) {
                    discovered.add(w);
                    queue.add(w);
                }
            }
        }
        // 더 이상 탐색할 노드가 없으면 리턴
        return discovered;
    }

    public static void main(String[] args) {
        graph.put(1, Arrays.asList(2, 3, 4));
        graph.put(2, Arrays.asList(5));
        graph.put(3, Arrays.asList(5));
        graph.put(4, Arrays.asList());
        graph.put(5, Arrays.asList(6, 7));
        graph.put(6, Arrays.asList());
        graph.put(7, Arrays.asList(3));

        List<Integer> r = new ArrayList<>();
        // 재귀 구조 DFS
        System.out.println(recursiveDFS(1, r));
        // 반복 구조 DFS
        System.out.println(iterativeDFS(1));
        // 반복 구조 BFS
        System.out.println(iterativeBFS(1));
    }
}
