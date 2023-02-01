package leetcode.greedy

class LC122 {
    fun maxProfit(prices: IntArray): Int {
        val diffArray = IntArray(prices.size - 1)
        for (i in 1 until prices.size) {
            println(i)
            diffArray[i - 1] = prices[i] - prices[i - 1]
        }
        var sum = 0
        for (i in diffArray.indices) {
            if (diffArray[i] > 0) {
                sum += diffArray[i]
            }
        }
        return sum
    }
}