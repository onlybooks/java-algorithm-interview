package ch24

class P101_3 {
    fun solution(board: Array<IntArray>, skill: Array<IntArray>): Int {
        val N: Int = board.size    // 행
        val M: Int = board[0].size // 열
        val matrix: Array<IntArray> = Array(N + 1) { IntArray(M + 1) }

        for (s in skill) {
            // s[0] 값에 따라 공격 또는 회복
            val degree = s[5] * if (s[0] == 1) -1 else 1

            matrix[s[1]][s[2]] += degree          // 상단   / 좌측
            matrix[s[1]][s[4] + 1] += degree * -1 // 상단   / 우측+1
            matrix[s[3] + 1][s[2]] += degree * -1 // 하단+1 / 좌측
            matrix[s[3] + 1][s[4] + 1] += degree  // 하단+1 / 우측+1
        }

        // 누적합 계산
        // 좌우
        for (i in 0 until N) {
            for (j in 1 until M) {
                matrix[i][j] += matrix[i][j - 1]
            }
        }
        // 상하
        for (j in 0 until M) {
            for (i in 1 until N) {
                matrix[i][j] += matrix[i - 1][j]
            }
        }

        // 파괴되지 않은 건물 개수 계산
        var answer = 0
        for (i in 0 until N) {
            for (j in 0 until M) {
                if (board[i][j] + matrix[i][j] > 0)
                    answer++
            }
        }
        return answer
    }
}