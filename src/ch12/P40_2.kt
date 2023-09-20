package ch12

import java.util.*

class P40_2 {
    fun subsets(nums: IntArray): List<List<Int>> {
        // 결과 저장 리스트 선언
        val results: MutableList<List<Int>> = mutableListOf()

        fun dfs(index: Int, path: Deque<Int>) {
            // 모든 탐색 경로를 매번 결과에 추가
            results.add(ArrayList(path))
            // 자기 자신보다 큰 숫자를 DFS 진행
            for (i in index until nums.size) {
                // path에 현재 엘리먼트 추가
                path.add(nums[i])
                // 재귀 DFS
                dfs(i + 1, path)
                // 돌아온 이후에는 현재 엘리먼트 삭제
                path.removeLast()
            }
        }

        // DFS 시작
        dfs(0, ArrayDeque())
        return results
    }
}