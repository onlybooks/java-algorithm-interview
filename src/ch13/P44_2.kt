package ch13

import java.util.*

class P44_2 {
    fun networkDelayTime(times: Array<IntArray>, n: Int, k: Int): Int {
        // 네트워크의 각 노드를 출발지 → 도착지 형태의 그래프로 구성
        val graph: MutableMap<Int, MutableMap<Int, Int>> = mutableMapOf()
        for (time in times) {
            // 값이 존재하지 않을 경우 빈 해시맵 생성
            graph.putIfAbsent(time[0], mutableMapOf())
            // 출발지에 (도착지, 소요 시간) 추가
            graph[time[0]]!![time[1]] = time[2]
        }

        // 우선순위 큐 생성, 값이 (도착지, 소요 시간)으로 구성되므로, 정렬 기준은 소요 시간을 기준으로 한다.
        val pq: Queue<Map.Entry<Int, Int>> = PriorityQueue(compareBy { (node, time) -> time })
        // (도착지, 소요 시간)을 큐에 삽입, 시작은 출발지 k이며, 소요 시간은 출발지이므로 당연히 0이다.
        pq.add(AbstractMap.SimpleEntry(k, 0))

        // (도착지, 소요 시간) 최종 결과를 저장하는 변수 선언
        val dist: MutableMap<Int, Int> = mutableMapOf()
        // 큐에 값이 남아 있다면 없어질 때까지 반복
        while (!pq.isEmpty()) {
            // 소요 시간이 가장 빠른 값 추출
            val (u, dist_u) = pq.poll()
            // u 지점까지의 소요 시간이 아직 계산되지 않았다면 처리 시작
            if (!dist.containsKey(u)) {
                // u 지점까지의 소요 시간(dist_u)을 결과 변수에 삽입
                dist[u] = dist_u
                // u 지점을 출발지로 한 경로가 있다면 처리 시작
                if (graph.containsKey(u)) {
                    // u 지점을 출발지로 한 모든 경로 순회
                    for ((v, length_u_v) in graph[u]!!) {
                        // u 지점까지의 소요 시간(dist_u) + u 지점을 출발지로 한 도착지까지의 소요 시간(length_u_v)
                        val alt = dist_u + length_u_v
                        // 우선순위 큐에 (도착지, 소요 시간)을 삽입
                        pq.add(AbstractMap.SimpleEntry(v, alt))
                    }
                }
            }
        }

        return if (dist.size == n)
        // 결과 변수가 노드의 수와 같다면 모든 노드의 소요 시간을 측정했고, 도달 가능하다는 의미
            Collections.max(dist.values)
        else
        // 같지 않다면 일부 노드에는 도달할 수 없으므로 문제 조건에 따라 -1 리턴
            -1
    }
}