package ch23;

public class P95_1 {
    public int solution(int[] money) {
        // 입력값이 1개인 경우 예외 처리
        if (money.length == 1)
            return money[0];

        int[][] dp = new int[2][money.length];
        dp[0][0] = 0; // 첫 번째 값은 사용하지 않음
        dp[1][0] = 0;
        dp[0][1] = 0; // 두 번째 값도 사용하지 않음
        dp[1][1] = money[1];
        // 이전 결과와 (전전 결과 + 현재 결과) 중 큰 값 저장, 두 번째 값 사용 유무에 따라 별도 계산
        for (int i = 2; i < money.length; i++) {
            dp[0][i] = Math.max(dp[0][i - 1], dp[0][i - 2] + money[i]);
            dp[1][i] = Math.max(dp[1][i - 1], dp[1][i - 2] + money[i]);
        }

        // 첫 번째 값과 이전 결과 또는 두 번째 값을 사용한 마지막 결과 중 큰 값을 정답으로 리턴
        return Math.max(money[0] + dp[0][money.length - 2], dp[1][money.length - 1]);
    }
}
