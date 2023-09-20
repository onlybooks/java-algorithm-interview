package ch23;

public class P91_2 {
    // 문제 제약 조건에 따라 30에서 1칸 더 크게 지정
    int[] dp = new int[31];

    public int fib(int n) {
        // 0과 1인 상향식과 마찬가지로 값을 미리 지정
        if (n <= 1)
            return n;

        // 미리 계산한 결과가 있다면 해당 값 리턴
        if (dp[n] != 0)
            return dp[n];
        dp[n] = fib(n - 1) + fib(n - 2);
        return dp[n];
    }
}
