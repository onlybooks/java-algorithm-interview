package ch12

class P43_3 {
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        val finishToTakeMap: MutableMap<Int, MutableList<Int>> = mutableMapOf()
        // 완료하기 위해 처리해야 하는 일정을 finish → take 형태의 그래프로 구성
        for (pre in prerequisites) {
            // 값이 존재하지 않을 경우 빈 리스트 생성
            finishToTakeMap.putIfAbsent(pre[0], mutableListOf())
            // 처리해야 하는 코스 추가
            finishToTakeMap[pre[0]]!!.add(pre[1])
        }

        // 처리해야 하는 노드를 저장하는 변수
        val takes: MutableList<Int> = mutableListOf()
        // 처리한 노드를 저장하는 변수
        val taken: MutableList<Int> = mutableListOf()

        fun dfs(finish: Int, takes: MutableList<Int>, taken: MutableList<Int>): Boolean {
            // 완료해야 하는 노드가 처리해야 하는 노드에 이미 포함되어 있다면
            // 그래프가 순환 구조이므로 false 리턴
            if (takes.contains(finish))
                return false

            // 이미 처리한 노드라면 true 리턴
            if (taken.contains(finish))
                return true

            // 완료해야 하는 코스에 값이 있다면
            if (finishToTakeMap.containsKey(finish)) {
                // 처리해야 하는 노드에 현재 완료해야 하는 노드 추가
                takes.add(finish)
                // 처리해야 하는 노드 순회
                for (take in finishToTakeMap[finish]!!) {
                    // 재귀 DFS, 탐색 결과가 false라면 false를 리턴한다.
                    if (!dfs(take, takes, taken))
                        return false
                }
                // 탐색 후에는 처리했으므로 노드 제거
                takes.remove(finish)
                // 이미 처리한 노드 추가
                taken.add(finish)
            }
            // 코스에 문제가 없으므로 true 리턴
            return true
        }

        // 완료해야 하는 노드 순회
        for (finish in finishToTakeMap.keys) {
            // DFS 결과가 false라면 최종 결과도 false로 리턴
            if (!dfs(finish, takes, taken))
                return false
        }
        // 모든 코스에 문제가 없으므로 true 리턴
        return true
    }
}