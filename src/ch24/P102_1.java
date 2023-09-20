package ch24;

class P102_1 {
    int[][] board;
    int N;
    int M;
    int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}}; // 동서남북

    public int dfs(int playerRow, int playerCol, int opponentRow, int opponentCol) {
        // 현재 내가 있는 곳에 발판이 없다면 패배
        if (board[playerRow][playerCol] == 0)
            return 0;

        int result = 0;
        // 동서남북 탐색
        for (int[] direction : directions) {
            int playerNextRow = playerRow + direction[0];
            int playerNextCol = playerCol + direction[1];

            // 다음 수가 갈 수 없는 곳이면 스킵
            if (playerNextRow < 0 || playerNextRow >= N || playerNextCol < 0 || playerNextCol >= M || board[playerNextRow][playerNextCol] == 0)
                continue;

            // 다음 수로 이동 예약 및 상대방 차례 시작
            board[playerRow][playerCol] = 0;
            int moveCount = dfs(opponentRow, opponentCol, playerNextRow, playerNextCol) + 1;
            board[playerRow][playerCol] = 1;

            // 지는 줄 알았는데 이기는 경우: 이동 횟수 결과로
            if (result % 2 == 0 && moveCount % 2 == 1)
                result = moveCount;
            // 지는 줄 알았는데 지는 경우: 이동 횟수 최대화
            else if (result % 2 == 0 && moveCount % 2 == 0)
                result = Math.max(result, moveCount);
            // 이기는 줄 알았는데 이기는 경우: 이동 횟수 최소화
            else if (result % 2 == 1 && moveCount % 2 == 1)
                result = Math.min(result, moveCount);
            // 이기는 줄 알았는데 지는 경우: 아무 처리 없이 패스
        }
        return result;
    }

    public int solution(int[][] board, int[] aloc, int[] bloc) {
        this.board = board;
        this.N = board.length;
        this.M = board[0].length;
        return dfs(aloc[0], aloc[1], bloc[0], bloc[1]);
    }
}
