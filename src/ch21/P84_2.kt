package ch21

class P84_2 {
    fun maxProfit(prices: IntArray): Int {
        var result = 0
        // 전체를 순회하며 다음번 값이 오르는 경우를 찾는다.
        for (i in prices.indices - 1) {
            // 다음번 값이 오르는 경우 항상 이익을 취한다.
            if (prices[i + 1] > prices[i])
                result += prices[i + 1] - prices[i]
        }
        return result
    }
}