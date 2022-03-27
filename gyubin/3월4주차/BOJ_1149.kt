import kotlin.math.min

private lateinit var arr: Array<IntArray>
private lateinit var cost: Array<IntArray>

private fun main() {
    // 1번 집의 색은 2번 집과 같지 않아야 한다.
    // N번 집의 색은 N-1번 집의 색과 같지 않아야 한다.
    // i번 집의 색은 i-1,i+1번 집의 색과 같지 않아야 한다.
    val n = readLine()!!.toInt()
    arr = Array(n) { IntArray(3) { 0 } }
    cost = Array(n) { IntArray(3) { 0 } }
    for (i in 0 until n) {
        cost[i] = readLine()!!.split(" ").map { it.toInt() }.toIntArray()
    }
    arr[0][0] = cost[0][0]
    arr[0][1] = cost[0][1]
    arr[0][2] = cost[0][2]
    println(min(solve(n - 1, 0), min(solve(n - 1, 1), solve(n - 1, 2))))
}

// 0: RED
// 1: GREEN
// 2: BLUE
private fun solve(n: Int, color: Int): Int {
    if (arr[n][color] == 0) {
        when (color) {
            0 -> {
                arr[n][0] = min(solve(n - 1, 1), solve(n - 1, 2)) + cost[n][0]
            }
            1 -> {
                arr[n][1] = min(solve(n - 1, 0), solve(n - 1, 2)) + cost[n][1]
            }
            2 -> {
                arr[n][2] = min(solve(n - 1, 0), solve(n - 1, 1)) + cost[n][2]
            }
        }
    }
    return arr[n][color]
}