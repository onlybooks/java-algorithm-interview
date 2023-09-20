package ch23;

public class P91_3 {
    public int fib(int n) {
        // 문제 제약 조건에 따라 30에서 1칸 더 크게 지정
        int[] dp = new int[31];
        // 0과 1의 값을 미리 지정
        dp[0] = 0;
        dp[1] = 1;

        // 2부터 차례대로 계산, 미리 계산한 결과를 이용해 계산 결과 누적
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
