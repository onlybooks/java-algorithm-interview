package ch13;

import java.util.*;

public class P45_2 {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // 여행 경로를 출발지 → 도착지 형태의 그래프로 구성
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        for (int[] flight : flights) {
            // 값이 존재하지 않을 경우 빈 해시맵 생성
            graph.putIfAbsent(flight[0], new HashMap<>());
            // 출발지에 (도착지, 비용) 추가
            graph.get(flight[0]).put(flight[1], flight[2]);
        }

        // 우선순위 큐 생성, 값은 (도착지, 비용, 진행 경로)로 구성하므로, 정렬은 비용(인덱스 1) 기준
        Queue<List<Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.get(1)));
        // (도착지, 비용, 진행 경로)을 큐에 삽입, 시작은 출발지 src이며, 비용과 진행 경로는 출발지이므로 당연히 모두 0
        pq.add(Arrays.asList(src, 0, 0));

        // 타임아웃을 방지하기 위해 한 번 방문한 경로는 저장해두는 맵 선언
        Map<Integer, Integer> visited = new HashMap<>();

        // 큐에 값이 남아 있다면 없어질 때 까지 반복
        while (!pq.isEmpty()) {
            // 비용이 가장 저렴한 값 추출
            List<Integer> cur = pq.poll();
            // 우선순위 큐의 항목은 List<Integer>이므로 인덱스 위치로 (도착지, 비용, 진행 경로) 각각 추출
            int u = cur.get(0);
            int price_u = cur.get(1);
            int k_visited = cur.get(2);

            // 만약 큐에서 추출한 값이 도착지 dst라면 정답으로 리턴
            if (u == dst)
                return price_u;

            // 도착지(u)까지 진행 경로(k_visited) 저장, 따로 저장해두진 않지만 비용(price_u)이 가장 저렴한 경로다.
            visited.put(u, k_visited);

            // 진행 경로(k_visited)가 남은 경로(k) 이내에 있다면 처리 계속
            if (k_visited <= k) {
                // 처리하면서 진행 경로 +1
                k_visited += 1;
                // u 지점을 출발지로 한 경로가 있다면 처리 시작
                if (graph.containsKey(u)) {
                    // u 지점을 출발지로 한 모든 경로 순회
                    for (Map.Entry<Integer, Integer> v : graph.get(u).entrySet()) {
                        // 이미 계산한 경로는 큐에 삽입하지 않는 형태로 풀이를 최적화한다.
                        // 그러나 아직 계산한 경로가 아니거나, 진행 경로(k_visited)가 기존보다 작다면 도착지(dst)까지는
                        // 또 다른 최소 비용을 계산할 가능성이 있으므로 큐에 삽입하여 한 번 더 계산 진행
                        if (!visited.containsKey(v.getKey()) || k_visited < visited.get(v.getKey())) {
                            // u 지점까지 비용(price_u) + u 지점을 출발지로 한 도착지까지 비용
                            int alt = price_u + v.getValue();
                            // 우선순위 큐에 (도착지, 비용, 진행 경로) 삽입
                            pq.add(Arrays.asList(v.getKey(), alt, k_visited));
                        }
                    }
                }
            }
        }
        // 큐의 모든 값이 비워질 때까지 리턴하지 못했다면 경로가 존재하지 않는다는 얘기이므로 -1 리턴
        return -1;
    }
}
