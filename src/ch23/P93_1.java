package ch23;

public class P93_1 {
    public int climbStairs(int n) {
        // 2 이하는 미리 지정한 값 리턴
        if (n <= 2)
            return n;
        return climbStairs(n - 1) + climbStairs(n - 2);
    }
}
