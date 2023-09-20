package ch18

class P74_2 {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        var row = 0
        // 첫 행의 맨 뒤로 지정
        var col = matrix[0].size - 1

        // 포인터가 행렬내에 있다면 계속 탐색
        while (row < matrix.size && col >= 0) {
            when {
                // 정답을 찾은 경우 true 리턴
                matrix[row][col] == target -> return true
                // 타깃보다 크면 왼쪽으로 이동
                matrix[row][col] > target -> col--
                // 타깃보다 작은 경우이므로 아래로 이동
                else -> row++
            }
        }
        return false
    }
}