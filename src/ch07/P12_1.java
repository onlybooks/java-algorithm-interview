package ch07;

public class P12_1 {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        // 구매 시점 순회, 처음부터 끝까지 차례대로 반복한다.
        for (int i = 0; i < prices.length; i++) {
            // 판매 시점 순회, 구매 다음부터 끝까지 차례대로 반복한다.
            for (int j = i + 1; j < prices.length; j++) {
                // 판매 시점 가격에서 구매 시점 가격을 뺄때 가장 높은 금액 찾기
                maxProfit = Math.max(maxProfit, prices[j] - prices[i]);
            }
        }
        return maxProfit;
    }
}
