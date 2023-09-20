package ch21;

public class P84_1 {
    public int maxProfit(int[] prices) {
        int result = 0;
        // 전체를 순회하며 다음번 값이 오르는 경우를 찾는다.
        for (int i = 0; i < prices.length - 1; i++) {
            // 다음번 값이 오르는 경우 항상 이익을 취한다.
            if (prices[i + 1] > prices[i])
                result += prices[i + 1] - prices[i];
        }
        return result;
    }
}
