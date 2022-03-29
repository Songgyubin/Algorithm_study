import kotlin.math.min

private fun main() {
    val INF: Int = 1000000000
    val n = readLine()!!.toInt()
    val m = readLine()!!.toInt()
    val arr = Array(n) { IntArray(n) { INF } }
    for (i in 0 until m) {
        val (a, b, c) = readLine()!!.split(" ").map { it.toInt() - 1 }
        arr[a][b] = min(arr[a][b], c + 1)
    }
    for (i in 0 until n) {
        arr[i][i] = 0
    }
    for (k in 0 until n) {
        for (i in 0 until n) {
            for (j in 0 until n) {
                arr[i][j] = min(arr[i][j], arr[i][k] + arr[k][j])
            }
        }
    }
    arr.forEach {
        it.forEach {
            if (it==INF) print("0 ")
            else print("$it ")
        }
        println()
    }
}
