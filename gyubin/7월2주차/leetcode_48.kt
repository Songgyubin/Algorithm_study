import kotlin.math.abs

// Rotate Image

private fun main() {
    rotate(arrayOf(intArrayOf(1,2,3), intArrayOf(4,5,6), intArrayOf(7,8,9)))
}


private fun rotate(matrix: Array<IntArray>): Unit {
    val tmpMatrix = Array(matrix.size) { IntArray(matrix[0].size) }
    for (i in 0 until matrix.size) {
        for (j in 0 until matrix[0].size) {
            tmpMatrix[i][j] = matrix[i][j]
        }
    }
    val lastIndex = matrix.lastIndex
    for (i in 0 until matrix.size) {
        for (j in 0 until matrix[0].size) {
            val x = j
            val y = abs(i - lastIndex)
            matrix[x][y] = tmpMatrix[i][j]
        }
    }

    matrix.forEach {
        println(it.joinToString(" "))
    }

}