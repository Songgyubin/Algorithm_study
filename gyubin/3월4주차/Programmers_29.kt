private fun main() {
    println(
        solution(
            5,
            arrayOf(intArrayOf(4, 3), intArrayOf(4, 2), intArrayOf(3, 2), intArrayOf(1, 2), intArrayOf(2, 5))
        )
    )
}

private fun solution(n: Int, results: Array<IntArray>): Int {
    var answer = 0
    val INF = 987654321
    val arr = Array<IntArray>(n + 1) { IntArray(n + 1) { INF } }
    results.forEach {
        val (win, lose) = it
        arr[win][lose] = 1
    }
    for (i in 0 until arr.size) {
        for (j in 0 until arr.size) {
            if (i == j) arr[i][j] = 0
        }
    }
    for (k in 1..n) {
        for (i in 1..n) {
            for (j in 1..n) {
                if (arr[i][j] > arr[i][k] + arr[k][j]) {
                    arr[i][j] = arr[i][k] + arr[k][j]
                }
            }
        }
    }
    var flag = BooleanArray(n + 1) { true }
    for (i in 1..n) {
        for (j in 1..n) {
            if (i == j) continue
            if (arr[i][j] == INF && arr[j][i] == INF) {
                flag[i] = false
                break
            }
        }
    }
   for (i in 1 until flag.size){
       if (flag[i]) answer++
   }
    return answer


}


