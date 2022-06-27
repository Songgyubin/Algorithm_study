import java.util.LinkedList
import java.util.Queue

private fun main() {

}

// Number of Islands
private val goX = intArrayOf(0, 0, 1, -1)
private val goY = intArrayOf(1, -1, 0, 0)

private lateinit var vis: Array<BooleanArray>
private var answer = 0
private fun numIslands(grid: Array<CharArray>): Int {

    val (n, m) = intArrayOf(grid.size, grid[0].size)
    vis = Array(n) { BooleanArray(m) }
    for (i in 0 until n) {
        for (j in 0 until m) {
            if (vis[i][j] || grid[i][j] == '0') continue
            bfs(i, j, grid)
            answer++
        }
    }

    return answer
}

private fun bfs(i: Int, j: Int, grid: Array<CharArray>) {
    val queue: Queue<Pair<Int, Int>> = LinkedList()
    queue.add(Pair(i, j))
    vis[i][j] = true
    while (queue.isNotEmpty()){
        val (x,y) = queue.poll()
        for (k in 0 until 4){
            val (nx,ny) = intArrayOf(x+goX[k],y+goY[k])
            if (nx !in 0 until grid.size || ny !in 0 until grid[0].size) continue
            if (vis[nx][ny]) continue
            if (grid[nx][ny]=='0') continue
            vis[nx][ny] = true
            queue.add(Pair(nx,ny))
        }
    }
}