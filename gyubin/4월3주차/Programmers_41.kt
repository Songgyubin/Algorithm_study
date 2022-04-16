import kotlin.math.min

private lateinit var villages: Array<IntArray>
private lateinit var vis: BooleanArray

private fun main() {
    println(solution(
        5,
        arrayOf(
            intArrayOf(1, 2, 1),
            intArrayOf(2, 3, 3),
            intArrayOf(5, 2, 2),
            intArrayOf(1, 4, 2),
            intArrayOf(5, 3, 1),
            intArrayOf(5, 4, 2)
        ),
        3
    ))
    solution(
        6,
        arrayOf(
            intArrayOf(1, 2, 1),
            intArrayOf(1, 3, 2),
            intArrayOf(2, 3, 2),
            intArrayOf(3, 4, 3),
            intArrayOf(3, 5, 2),
            intArrayOf(3, 5, 3),
            intArrayOf(5, 6, 1)
        ),
        4
    )

}

private fun solution(N: Int, road: Array<IntArray>, k: Int): Int {
    var answer = 0
    // 1번 마을에서 출발
    // n개의 마을 중 k 시간 이하로 가능한 마을
    villages = Array(N) { IntArray(N) { 0 } }
    vis = BooleanArray(N)
    for (i in 0 until N) {
        for (j in 0 until N) {
            if (i == j) continue
            villages[i][j] = 500_001
        }
    }
    road.forEach {
        val (first, second, time) = it
        villages[first - 1][second - 1] = min(villages[first - 1][second - 1],time)
        villages[second - 1][first - 1] = min(villages[second - 1][first - 1],time)
    }
    for (c in 0 until N) {
        for (i in 0 until N) {
            for (j in 0 until N) {
                villages[i][j] = min(villages[i][j], villages[i][c] + villages[c][j])
            }
        }
    }

    return villages[0].count { it <= k }
}