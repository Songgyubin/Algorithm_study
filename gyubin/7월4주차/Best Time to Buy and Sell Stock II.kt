private fun main() {
    println(maxProfit(intArrayOf(1, 2, 3, 4, 5)))
}

private fun maxProfit(prices: IntArray): Int {

    var i = 0
    var buy: Int
    var sell: Int
    var profit = 0
    val N: Int = prices.size - 1
    while (i < N) {
        while (i < N && prices[i + 1] <= prices[i]) i++
        buy = prices[i]
        while (i < N && prices[i + 1] > prices[i]) i++
        sell = prices[i]
        profit += sell - buy
    }
    return profit
}