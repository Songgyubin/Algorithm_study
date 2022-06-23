// Climbing Stairs
private fun main() {
    println(climbStairs(4))
}


private fun climbStairs(n: Int): Int {
    val dp = IntArray(46)
    dp[0] = 1
    dp[1] = 1
    for (i in 2..45) {
        dp[i] = dp[i-1]+dp[i-2]
    }
    return dp[n]
}
