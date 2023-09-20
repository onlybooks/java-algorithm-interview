package ch18;

public class P74_1 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        // 첫 행의 맨 뒤로 지정
        int col = matrix[0].length - 1;

        // 포인터가 행렬내에 있다면 계속 탐색
        while (row < matrix.length && col >= 0) {
            // 정답을 찾은 경우 true 리턴
            if (matrix[row][col] == target) {
                return true;
            // 타깃보다 크면 왼쪽으로 이동
            } else if (matrix[row][col] > target) {
                col--;
            // 타깃보다 작은 경우이므로 아래로 이동
            } else {
                row++;
            }
        }
        return false;
    }
}
