import java.util.*


private fun main() {
    println(
        solution(
            arrayOf(
                intArrayOf(1, 1, 0, 0, 1, 0),
                intArrayOf(0, 0, 1, 0, 1, 0),
                intArrayOf(0, 1, 1, 0, 0, 1),
                intArrayOf(1, 1, 0, 1, 1, 1),
                intArrayOf(1, 0, 0, 0, 1, 0),
                intArrayOf(0, 1, 1, 1, 0, 0)
            ), arrayOf(
                intArrayOf(1, 0, 0, 1, 1, 0),
                intArrayOf(1, 0, 1, 0, 1, 0),
                intArrayOf(0, 1, 1, 0, 1, 1),
                intArrayOf(0, 0, 1, 0, 0, 0),
                intArrayOf(1, 1, 0, 1, 1, 0),
                intArrayOf(0, 1, 0, 0, 0, 0)
            )
        )
    )// 14

//    println(solution(arrayOf(intArrayOf(0,0,0), intArrayOf(1,1,0), intArrayOf(1,1,1)), arrayOf(intArrayOf(1,1,1),
//        intArrayOf(1,0,0), intArrayOf(0,0,0)
//    ))) //0
}

private val goX = intArrayOf(-1, 1, 0, 0) //상하좌우
private val goY = intArrayOf(0, 0, -1, 1)

private lateinit var tableBoard: ArrayList<ArrayList<Point>>
private lateinit var gameBoard: ArrayList<ArrayList<Point>>
private lateinit var vis: Array<BooleanArray>
private lateinit var blockVis: BooleanArray
private const val HOLE = 0
private const val BLOCK = 1

private fun solution(game_board: Array<IntArray>, table: Array<IntArray>): Int {
    var answer: Int = 0
    // 퍼즐조각을 게임 보드의 빈 공간에 적절히 올려놓으려한다.
    // 조각은 한 번에 하나씩 채워 넣기
    // 조각을 회전시킬 수 있음
    // 뒤집을 수는 없다
    // 새로 채워 넣은 퍼즐 조각과 인접한 칸이 비어있으면 안 된다.
    // 빈 공간 그룹의 칸 개수 동일,
    // 0,0으로 시작하게끔 좌표를 변경하자
    // 모양 모양을 회전시키지 말고, 테이블 전체를 회전하여 모양을 맞추고,
    // 그리고 각 모양 및 빈칸들은 list로 넣어두고 비교하자
    gameBoard = ArrayList()
    tableBoard = ArrayList()
    vis = Array(game_board.size) { BooleanArray(game_board.size) }
    for (i in 0 until game_board.size) {
        for (j in 0 until game_board.size) {
            if (game_board[i][j] == HOLE && !vis[i][j]) {
                gameBoard.add(findHoleOrPuzzle(game_board, i, j, HOLE))
            }
        }
    }
    vis = Array(game_board.size) { BooleanArray(game_board.size) }
    for (i in 0 until game_board.size) {
        for (j in 0 until game_board.size) {
            if (table[i][j] == BLOCK && !vis[i][j]) {
                tableBoard.add(findHoleOrPuzzle(table, i, j, BLOCK))
            }
        }
    }
    blockVis = BooleanArray(gameBoard.size)
    for (i in 0 until tableBoard.size) {
        val checkBlock = tableBoard[i]
        for (j in 0 until gameBoard.size) {
            val checkHole = gameBoard[j]
            if (checkBlock.size != checkHole.size) continue
            if (blockVis[j]) continue
            if (isRotate(checkHole, checkBlock)) {
                answer += checkBlock.size
                blockVis[j] = true
                break
            }
        }
    }
    return answer
}


private fun isRotate(hole: ArrayList<Point>, block: ArrayList<Point>): Boolean {
    for (i in 0..3) {
        val zeroX = block[0].x
        val zeroY = block[0].y

        // 회전시키면서 좌표가 달라지기 때문에 다시 (0, 0)을 기준으로 블록 좌표를 변경
        for (j in 0 until block.size) {
            block[j].x -= zeroX
            block[j].y -= zeroY
        }
        var isCollect = true
        for (j in 0 until hole.size) {
            val (x, y) = hole[j]
            val (x1, y1) = block[j]

            // 블록 좌표가 빈 공간의 좌표와 하나라도 다르면 중단
            if (x != x1 || y != y1) {
                isCollect = false
                break
            }
        }
        if (isCollect) {
            return true
        } else {
            // 90도 회전 : (x, y) -> (y, -x)
            for (j in 0 until block.size) {
                val temp = block[j].x
                block[j].x = block[j].y
                block[j].y = -temp
            }
            block.sort()
        }
    }

    return false
}

private fun findHoleOrPuzzle(board: Array<IntArray>, i: Int, j: Int, type: Int): ArrayList<Point> {
    val n = board.size
    val result = ArrayList<Point>()
    vis[i][j] = true
    result.add(Point(0, 0))
    val queue = LinkedList<Pair<Int, Int>>()
    queue.add(Pair(i, j))
    while (queue.isNotEmpty()) {
        val (x, y) = queue.poll()
        for (k in 0 until 4) {
            val (nx, ny) = intArrayOf(x + goX[k], y + goY[k])
            if (nx !in 0 until n || ny !in 0 until n) continue
            if (!vis[nx][ny] && board[nx][ny] == type) {
                vis[nx][ny] = true
                queue.add(Pair(nx, ny))
                result.add(Point(nx - i, ny - j))
            }
        }
    }
    result.sort()
    return result
}

data class Point(var x: Int, var y: Int) : Comparable<Point> {
    override fun compareTo(other: Point): Int {
        if (this.x == other.x) return this.y - other.y
        return this.x - other.x
    }

}
