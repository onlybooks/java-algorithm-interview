package ch12

import java.util.*
import java.util.stream.Collectors

class P38_2 {
    fun combine(n: Int, k: Int): List<List<Int>> {
        // 결과 저장 리스트 선언
        val results: MutableList<List<Int>> = mutableListOf()

        fun dfs(elements: LinkedList<Int>, start: Int, k: Int) {
            // k번째 노드에 도달하면 결과에 추가
            if (k == 0) {
                // 자바 8+의 스트림을 이용해 elements의 내용을 결과에 삽입
                results.add(elements.stream().collect(Collectors.toList()))
                return
            }

            // 현재 엘리먼트 이후 엘리먼트 탐색
            for (i in start..n) {
                // 전달받은 엘리먼트에 더해 현재 엘리먼트 추가
                elements.add(i)
                // 재귀 DFS
                dfs(elements, i + 1, k - 1)
                // 돌아온 이후에는 현재 엘리먼트 삭제
                elements.removeLast()
            }
        }

        // DFS 시작
        dfs(LinkedList(), 1, k)
        return results
    }
}