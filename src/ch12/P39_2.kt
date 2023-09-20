package ch12

import java.util.*

class P39_2 {
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        // 결과 저장 리스트 선언
        val results: MutableList<List<Int>> = mutableListOf()

        fun dfs(target: Int, index: Int, path: Deque<Int>) {
            // 0 보다 작다면 목푯값을 넘어섰으므로 리턴
            if (target < 0) return
            // 0이면 목푯값에 도달했으므로 결과에 추가하고 리턴
            if (target == 0) {
                // 이전 경로를 저장해둔 path를 결과에 삽입
                results.add(ArrayList(path))
                return
            }
            // 자기 자신보다 큰 숫자를 DFS 진행
            for (i in index until candidates.size) {
                // path에 현재 엘리먼트 추가
                path.add(candidates[i])
                // 재귀 DFS
                dfs(target - candidates[i], i, path)
                // 돌아온 이후에는 현재 엘리먼트 삭제
                path.removeLast()
            }
        }

        // DFS 시작
        dfs(target, 0, ArrayDeque())
        return results
    }
}