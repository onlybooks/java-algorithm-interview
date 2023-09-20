package ch12

class P35_2 {
    fun numIslands(grid: Array<CharArray>): Int {
        fun dfs(i: Int, j: Int) {
            // 현재 위치가 그리드 밖이거나, 물(0)인 경우 종료
            when {
                (i < 0) ||
                        (i >= grid.size) ||
                        (j < 0) ||
                        (j >= grid[0].size) ||
                        (grid[i][j] == '0') -> return
            }
            // 한 번만 탐색하기 위해 탐색한 지점은 물(0)로 변경
            grid[i][j] = '0'
            // 동서남북 재귀 DFS
            dfs(i, j + 1) // 동
            dfs(i, j - 1) // 서
            dfs(i + 1, j) // 남
            dfs(i - 1, j) // 북
        }

        var count = 0
        // 행렬을 모두 탐색
        for (i in grid.indices) {
            for (j in grid[i].indices) {
                // 만약 육지(1)인 경우 DFS 시작
                if (grid[i][j] == '1') {
                    dfs(i, j)
                    // 재귀 DFS가 모두 끝나면 섬 하나가 완성됐으므로 +1
                    count++
                }
            }
        }
        // 섬의 개수 리턴
        return count
    }
}