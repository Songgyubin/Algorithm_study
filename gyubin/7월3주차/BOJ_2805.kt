private fun main() {
    // 절단기 높이 H
    // 적어도 m미터의 나무를 가져가기 위해
    // 절단기에 설정할 수 있는 높이의 최댓값

    // n: 나무의 수
    // m: 가져가려고 하는 나무의 길이
    val (n, m) = readln().split(" ").map { it.toInt() }
    val arr = readln().split(" ").map { it.toLong() }.toLongArray()

    var left = 0L
    var right = arr.maxOf { it } + 1
    while (left < right) {
        val mid = (left + right) / 2
        val cutting = calcTreeHeight(arr, mid)
        if (cutting < m) right = mid
        else left = mid + 1
    }
    println(left-1)

}

private fun calcTreeHeight(arr: LongArray, cut: Long) = arr.sumOf { if (it < cut) 0 else it - cut }