package ch24

import java.util.*

class P100_2 {
    // from → to 그래프
    val graph: MutableMap<Int, MutableList<Int>> = mutableMapOf()
    var answer = 1

    data class Node(val index: Int, val sheep: Int, val wolves: Int, val nodes: List<Int>)

    fun solution(info: IntArray, edges: Array<IntArray>): Int {
        // from → to 그래프 구성
        for (edge in edges) {
            graph.putIfAbsent(edge[0], mutableListOf())
            graph[edge[0]]!!.add(edge[1])
        }

        val queue: Queue<Node> = LinkedList()
        queue.offer(Node(0, 1, 0, graph[0]!!))

        while (!queue.isEmpty()) {
            val node = queue.poll()

            // 해당 노드에서 진행 가능 노드 모두 탐색
            for (nextNode in node.nodes) {
                val nextSheep = if (info[nextNode] == 0) node.sheep + 1 else node.sheep
                val nextWolves = if (info[nextNode] == 1) node.wolves + 1 else node.wolves

                // 다음 노드에 방문이 가능하다면 처리 및 큐 삽입
                if (nextSheep > nextWolves) {
                    // 최댓값이면 교체
                    answer = answer.coerceAtLeast(nextSheep)

                    // 동일한 값을 참조하지 않기 위해 새롭게 생성해서 부여
                    val candidateNodes: MutableList<Int> = ArrayList(node.nodes)
                    // 현재 처리 중 노드는 값을 찾아서 삭제
                    candidateNodes.remove(nextNode)
                    // 방문 가능한 노드 추가
                    if (graph[nextNode] != null)
                        candidateNodes.addAll(graph[nextNode]!!)

                    // 큐 삽입(BFS)
                    queue.offer(Node(nextNode, nextSheep, nextWolves, candidateNodes))
                }
            }
        }
        return answer
    }
}