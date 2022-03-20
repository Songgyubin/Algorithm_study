import kotlin.math.min

private lateinit var arr: Array<IntArray>

private fun main() {
    val n = readLine()!!.toInt()
    val m = readLine()!!.toInt()
    arr = Array(n) { IntArray(n) { 0 } }
    for (i in 0 until n){
        for (j in 0 until n){
            if (i==j) continue
            arr[i][j] = 100_000
        }
    }
    for (i in 0 until m ) {
        val (a, b, c) = readLine()!!.split(" ").map { it.toInt() }.toTypedArray().also {
            it[0] = it[0] - 1
            it[1] = it[1] - 1
        }
        arr[a][b] = min(arr[a][b], c)
    }
    for (k in 0 until n) {
        for (i in 0 until n) {
            for (j in 0 until n) {
                arr[i][j] = min(arr[i][j], (arr[i][k] + arr[k][j]))
            }
        }
    }
    for (i in 0 until n){
        for (j in 0 until n){
            print("${arr[i][j]} ")
        }
        println()
    }
}