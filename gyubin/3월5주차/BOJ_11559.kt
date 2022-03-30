import java.util.*
import kotlin.collections.ArrayList

private val goX = intArrayOf(1, -1, 0, 0)
private val goY = intArrayOf(0, 0, 1, -1)
private lateinit var arr: Array<CharArray>
private lateinit var vis: Array<BooleanArray>

private fun main() {
    var answer = 0
    arr = Array(12) { CharArray(6) }
    vis = Array(12) { BooleanArray(6) }

    for (i in 0 until 12) {
        arr[i] = readLine()!!.toCharArray()
    }
    while (true) {
        val flag = bfs(12, 6)
        downPuyo(12, 6)
        vis = Array(12) { BooleanArray(6) }

        if (!flag) break
        else answer++
    }
    println(answer)
}

private fun downPuyo(n: Int, m: Int) {

    for (i in 0 until m) {
        for (j in n - 1 downTo 0) {
            if (arr[j][i] != '.') continue
            for (k in j - 1 downTo 0) {
                if (arr[k][i] == '.') continue
                arr[j][i] = arr[k][i]
                arr[k][i] = '.'
                break
            }
        }
    }
}

private fun bfs(n: Int, m: Int): Boolean {
    var result = false
    val removedPuyo = ArrayList<Pair<Int, Int>>()
    for (i in n - 1 downTo 0) {
        for (j in m - 1 downTo 0) {
            if (vis[i][j] || arr[i][j] == '.') continue
            vis[i][j] = true
            val queue = LinkedList<Pair<Int, Int>>()
            queue.add(Pair(i, j))
            removedPuyo.add(Pair(i, j))
            val color = arr[i][j]
            var colorCount = 1
            while (queue.isNotEmpty()) {
                val (x, y) = queue.poll()
                for (k in 0 until 4) {
                    val (nX, nY) = intArrayOf(x + goX[k], y + goY[k])
                    if (nX !in 0 until n || nY !in 0 until m) continue
                    if (vis[nX][nY] || arr[nX][nY] == '.') continue
                    if (color != arr[nX][nY]) continue
                    vis[nX][nY] = true
                    queue.add(Pair(nX, nY))
                    removedPuyo.add(Pair(nX, nY))
                    colorCount++
                }
            }
            if (colorCount >= 4) {
                result = true
                removedPuyo.forEach {
                    arr[it.first][it.second] = '.'
                }
            }
            removedPuyo.clear()
        }
    }
    return result
}