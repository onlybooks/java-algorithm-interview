package ch07;

public class P12_2 {
    public int maxProfit(int[] prices) {
        // 최대 이익은 0, 저점은 임시로 첫 번째 값으로 지정
        int maxProfit = 0, minPrice = prices[0];
        // 현재 값을 우측으로 차례대로 이동하면서 계산
        for (int price : prices) {
            // 지금까지 저점 계산
            minPrice = Math.min(minPrice, price);
            // 현재 값과 저점의 차이가 최대 이익인 경우 교체
            maxProfit = Math.max(maxProfit, price - minPrice);
        }
        return maxProfit;
    }
}
