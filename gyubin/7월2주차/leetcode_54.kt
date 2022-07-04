// Spiral Matrix

private fun main() {
    println(spiralOrder(arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6), intArrayOf(7, 8, 9))).joinToString(" "))
}

private lateinit var vis: Array<BooleanArray>
private fun spiralOrder(matrix: Array<IntArray>): List<Int> {
    vis = Array(matrix.size) { BooleanArray(matrix[0].size) }
    val answer = mutableListOf<Int>()
    var startX = 0
    var endX = matrix.size
    var startY = 0
    var endY = matrix[0].size

    while (startX <= endX && startY <= endY) {
        cycleMove(startX, startY, endX, endY, answer, matrix)
        startX++
        endX--
        startY++
        endY--
    }
    return answer
}

private fun cycleMove(
    startX: Int,
    startY: Int,
    endX: Int,
    endY: Int,
    answer: MutableList<Int>,
    matrix: Array<IntArray>
) {
    // top
    for (i in startY until endY) {
        if (vis[startX][i]) continue
        vis[startX][i] = true
        answer.add(matrix[startX][i])
    }
    // right
    for (i in startX + 1 until endX) {
        if (vis[i][endY - 1]) continue
        vis[i][endY - 1] = true

        answer.add(matrix[i][endY - 1])
    }
    // bottom
    for (i in endY - 2 downTo startY) {
        if (vis[endX - 1][i]) continue
        vis[endX - 1][i] = true

        answer.add(matrix[endX - 1][i])
    }
    // left
    for (i in endX - 2 downTo startX + 1) {
        if (vis[i][startY]) continue
        vis[i][startY] = true

        answer.add(matrix[i][startY])
    }

}