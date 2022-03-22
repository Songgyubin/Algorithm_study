import kotlin.math.min

private lateinit var arr: Array<IntArray>
private val INF: Int = 1000000000

private fun main() {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    arr = Array(n) { IntArray(n) { INF } }

    for (i in 0 until m) {
        val (a, b) = readLine()!!.split(" ").map { it.toInt() - 1 }
        arr[a][b] = 1
        arr[b][a] = 1
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
    var count = arr.minOf { it.sum() }
    val answer = ArrayList<Int>()
    for (i in 0 until arr.size) {
        if (arr[i].sum() == count) {
            count = arr[i].sum()
            answer.add(i)
        }
    }
    println(answer.minOrNull()!! + 1)
}