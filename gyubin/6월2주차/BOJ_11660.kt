private lateinit var arr: Array<IntArray>
private lateinit var sum: Array<IntArray>

private fun main() {

    val (n, m) = readln().split(" ").map { it.toInt() }
    arr = Array(n + 1) { IntArray(n + 1) }
    sum = Array(n + 1) { IntArray(n + 1) }
    for (i in 1..n) {
        val a =  readln().split(" ").map { it.toInt() }.toIntArray()
        for (j in 1..n){
            arr[i][j] = a[j-1]
        }
    }
    for (i in 1..n){
     for (j in 1..n){
         sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] + arr[i][j]
     }
    }

    for (i in 1 .. m) {
        val (x1, y1, x2, y2) = readln().split(" ").map { it.toInt() }
        val result = sum[x2][y2] - sum[x2][y1-1] - sum[x1-1][y2] + sum[x1-1][y1-1]
        println(result)
    }
}