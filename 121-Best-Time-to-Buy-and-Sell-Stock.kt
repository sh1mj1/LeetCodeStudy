class Solution {
    fun maxProfit(prices: IntArray): Int {
        if(prices.isEmpty()) return 0

        var minPrice = Int.MAX_VALUE
        var maxProfit = 0
        for(price in prices) {
            minPrice = min(minPrice, price)
            maxProfit = max(maxProfit, price - minPrice)
        }
        return maxProfit
    }
}

