// Set Matrix Zeroes

private val goX = intArrayOf(0, 0, 1, -1)
private val goY = intArrayOf(1, -1, 0, 0)
private fun main() {
    setZeroes(arrayOf(intArrayOf(1, 1, 1), intArrayOf(1, 0, 1), intArrayOf(1, 1, 1)))
}

private fun setZeroes(matrix: Array<IntArray>): Unit {
    val queue = java.util.LinkedList<Pair<Int, Int>>()
    for (i in 0 until matrix.size) {
        for (j in 0 until matrix[0].size) {
            if (matrix[i][j] == 0) queue.add(Pair(i, j))
        }
    }
    while (queue.isNotEmpty()) {
        var (x, y) = queue.peek()
        while (true) {
            x += goX[0]
            y += goY[0]
            if (x !in 0 until matrix.size || y !in 0 until matrix[0].size) break
            matrix[x][y] = 0
        }
        x = queue.peek().first
        y = queue.peek().second
        while (true) {
            x += goX[1]
            y += goY[1]
            if (x !in 0 until matrix.size || y !in 0 until matrix[0].size) break
            matrix[x][y] = 0
        }
        x = queue.peek().first
        y = queue.peek().second
        while (true) {
            x += goX[2]
            y += goY[2]
            if (x !in 0 until matrix.size || y !in 0 until matrix[0].size) break
            matrix[x][y] = 0
        }
        x = queue.peek().first
        y = queue.peek().second
        while (true) {
            x += goX[3]
            y += goY[3]
            if (x !in 0 until matrix.size || y !in 0 until matrix[0].size) break
            matrix[x][y] = 0
        }
        queue.poll()
    }

}