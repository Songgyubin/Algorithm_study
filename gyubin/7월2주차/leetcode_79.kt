// Word Search

private fun main() {
    println(
        exist(
            arrayOf(
                charArrayOf('A', 'B', 'C', 'E'),
                charArrayOf('S', 'F', 'C', 'S'),
                charArrayOf('A', 'D', 'E', 'E')
            ), "ABCCED"
        )
    )
}

private val goX = intArrayOf(0, 0, 1, -1)
private val goY = intArrayOf(1, -1, 0, 0)
private var answer = false

private fun exist(board: Array<CharArray>, word: String): Boolean {

    for (i in 0 until board.size) {
        for (j in 0 until board[0].size) {
            if (board[i][j] != word[0]) continue
            val vis = Array(board.size) { BooleanArray(board[0].size) }
            dfs(board, word, vis, board[i][j].toString(), i, j)
        }
    }

    return answer
}

private fun dfs(
    board: Array<CharArray>,
    word: String,
    vis: Array<BooleanArray>,
    result: String,
    x: Int,
    y: Int
) {
    if (result == word) {
        answer = true
        return
    }
    vis[x][y] = true
    for (i in 0 until 4) {
        val (nx, ny) = intArrayOf(x + goX[i], y + goY[i])
        if (nx !in 0 until board.size || ny !in 0 until board[0].size) continue
        if (vis[nx][ny]) continue
        if (board[nx][ny] != word[result.length]) continue
        if (result.length > word.length) continue
        vis[nx][ny] = true
        dfs(board, word, vis, result + board[nx][ny], nx, ny)
        vis[nx][ny] = false

    }
    return
}
