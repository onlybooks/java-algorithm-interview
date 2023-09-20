package ch14

class P54_2 {
    fun findMinHeightTrees(n: Int, edges: Array<IntArray>): List<Int> {
        // 예외 처리
        if (n == 1) return listOf(0)

        // 트리 그래프 변수
        val graph: MutableMap<Int, MutableList<Int>> = mutableMapOf()
        // 트리 구조를 양방향 그래프로 구성
        for (edge in edges) {
            // 값이 존재하지 않을 경우 빈 리스트 생성
            graph.putIfAbsent(edge[0], mutableListOf())
            graph.putIfAbsent(edge[1], mutableListOf())
            // 양방향으로 구성
            graph[edge[0]]!!.add(edge[1])
            graph[edge[1]]!!.add(edge[0])
        }

        // 첫 번째 리프 노드 추가
        var leaves: MutableList<Int> = mutableListOf()
        for (i in 0 until n)
            // 연결이 하나인 노드를 리프 노드로 추가
            if (graph[i]!!.size == 1) leaves.add(i)

        // 남은 리프 노드 개수, 초깃값은 전체 노드 수
        var left = n
        // 루트 노드(2개 이하)만 남을 때까지 반복 제거
        while (left > 2) {
            // 이전 단계 리프 노드 개수만큼 n에서 제거
            left -= leaves.size
            // 단계별로 새롭게 리프 노드 변수 선언
            val newLeaves: MutableList<Int> = mutableListOf()
            for (leaf in leaves) {
                // 리프 노드의 이웃 노드 추출
                val neighbor = graph[leaf]!![0]
                // 이웃 노드에서 리프 노드까지 연결 삭제
                graph[neighbor]!!.remove(leaf)

                // 이웃 노드가 리프 노드인 경우 newLeaves에 추가
                if (graph[neighbor]!!.size == 1) newLeaves.add(neighbor)
            }
            // 현재 단계에서 리프 노드를 모두 추가한 newLeaves → leaves
            leaves = newLeaves
        }
        // 2개 이하가 남은 최종 결과 리턴
        return leaves
    }
}