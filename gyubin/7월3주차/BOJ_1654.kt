import kotlin.math.max

private fun main() {
    val (k, n) = readln().split(" ").map { it.toInt() }
    val target = mutableListOf<Long>()

    var right = 0L
    for (i in 0 until k) {
        readln().toLong().let {
            target.add(it)
            right = max(right, it)
        }
    }
    right++
    var left = 0L
    while (left < right) {
        val mid = (left + right) / 2
        val lines = countLines(target, mid)
        if (lines < n) right = mid
        else left = mid + 1
    }
    println(left - 1)
}

private fun countLines(arr: List<Long>, cut: Long): Long = arr.sumOf { it / cut }
