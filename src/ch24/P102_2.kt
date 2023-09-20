package ch24

class P102_2 {
    lateinit var board: Array<IntArray>
    var N = 0
    var M = 0
    val directions: Array<IntArray> = arrayOf(intArrayOf(0, 1), intArrayOf(0, -1), intArrayOf(1, 0), intArrayOf(-1, 0)) // 동서남북

    fun dfs(playerRow: Int, playerCol: Int, opponentRow: Int, opponentCol: Int): Int {
        // 현재 내가 있는 곳에 발판이 없다면 패배
        if (board[playerRow][playerCol] == 0)
            return 0

        var result = 0
        // 동서남북 탐색
        for (direction in directions) {
            val playerNextRow = playerRow + direction[0]
            val playerNextCol = playerCol + direction[1]

            // 다음 수가 갈 수 없는 곳이면 스킵
            if (playerNextRow < 0 || playerNextRow >= N || playerNextCol < 0 || playerNextCol >= M || board[playerNextRow][playerNextCol] == 0)
                continue

            // 다음 수로 이동 예약 및 상대방 차례 시작
            board[playerRow][playerCol] = 0
            val moveCount = dfs(opponentRow, opponentCol, playerNextRow, playerNextCol) + 1
            board[playerRow][playerCol] = 1

            when {
                // 지는 줄 알았는데 이기는 경우: 이동 횟수 결과로
                (result % 2 == 0 && moveCount % 2 == 1) -> result = moveCount
                // 지는 줄 알았는데 지는 경우: 이동 횟수 최대화
                (result % 2 == 0 && moveCount % 2 == 0) -> result = result.coerceAtLeast(moveCount)
                // 이기는 줄 알았는데 이기는 경우: 이동 횟수 최소화
                (result % 2 == 1 && moveCount % 2 == 1) -> result = result.coerceAtMost(moveCount)
                // 이기는 줄 알았는데 지는 경우: 아무 처리 없이 패스
            }
        }
        return result
    }

    fun solution(board: Array<IntArray>, aloc: IntArray, bloc: IntArray): Int {
        this.board = board
        N = board.size
        M = board[0].size
        return dfs(aloc[0], aloc[1], bloc[0], bloc[1])
    }
}