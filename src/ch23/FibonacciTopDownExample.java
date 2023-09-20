package ch23;

class FibonacciTopDownExample {
    static int[] dp = new int[100];

    static public int fib(int n) {
        // 0과 1인 상향식과 마찬가지로 값을 미리 지정
        if (n <= 1)
            return n;

        // 미리 계산한 결과가 있다면 해당 값 리턴
        if (dp[n] != 0)
            return dp[n];
        dp[n] = fib(n - 1) + fib(n - 2);
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(fib(10));
    }
}
