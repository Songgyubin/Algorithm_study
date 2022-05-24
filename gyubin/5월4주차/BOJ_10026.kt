import java.util.LinkedList

private val goX = intArrayOf(1, -1, 0, 0)
private val goY = intArrayOf(0, 0, 1, -1)
private lateinit var vis: Array<BooleanArray>
private lateinit var arr: Array<CharArray>

var answer1 = 0
var answer2 = 0
private fun main() {
    // 적록색약은 빨간색과 초록색이 같은 경우
    val n = readln().toInt()
    arr = Array(n) { CharArray(n) }
    vis = Array(n) { BooleanArray(n) }

    for (i in 0 until n) {
        arr[i] = readln().toCharArray()
    }
    for (i in 0 until n){
        for (j in 0 until n){
            if (vis[i][j]) continue
            dfs(Pair(i, j), n)
            answer1++
        }
    }
    for (i in 0 until n){
        for (j in 0 until n){
            if (arr[i][j]=='G') arr[i][j] ='R'
        }
    }
    vis = Array(n){BooleanArray(n)}
    for (i in 0 until n){
        for (j in 0 until n){
            if (vis[i][j]) continue
            dfs(Pair(i, j), n)
            answer2++
        }
    }

    println("$answer1 $answer2")
}

private fun dfs(start: Pair<Int, Int>, n: Int) {
    val (x, y) = start
    vis[x][y] = true
    val color = arr[x][y]
    for (i in 0 until 4) {
        val (nx, ny) = intArrayOf(x + goX[i], y + goY[i])
        if (nx !in 0 until n || ny !in 0 until n) continue
        if (vis[nx][ny]) continue
        val nColor = arr[nx][ny]
        if (color == nColor) {
            dfs(Pair(nx, ny), n)
        }
    }
}