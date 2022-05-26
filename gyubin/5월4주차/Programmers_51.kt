import java.util.LinkedList
import java.util.Queue
import kotlin.math.min

private fun main() {
    solution(arrayOf(intArrayOf(0, 0, 0), intArrayOf(0, 0, 0), intArrayOf(0, 0, 0)))
}

private val goX = intArrayOf(0, 0, 1, -1) //우, 좌, 하, 상
private val goY = intArrayOf(1, -1, 0, 0)
private var answer = Int.MAX_VALUE
private lateinit var vis: Array<BooleanArray>
private lateinit var priceArr: Array<Array<IntArray>>

private fun solution(board: Array<IntArray>): Int {
    // 0 또는 1
    // 0은 비움 1은 벽
    // 0,0부터 n-1,n-1까지 경주로 건설 필요
    // 상 하 좌 우
    // 인접한 두 빈 칸을 상하 또는 좌우로 연결한 경주로: 직선 도로
    // 직선 도로가 서로 직각으로 만나면 코너
    // 직선 도로 한 개: 100원
    // 코너: 500원 근데 600으로 처리해야함
    // 경주로 건설 최소 비용
    // 재방문 허용
    // bfs
    vis = Array(board.size) { BooleanArray(board.size) }
    // 방향, x,y
    priceArr = Array(4){Array(board.size) { IntArray(board.size) { Int.MAX_VALUE } }}
    bfs(board)
    println(answer)
    return answer
}

private fun bfs(board: Array<IntArray>) {
    val n = board.size
    val queue: Queue<Road> = LinkedList()
    queue.add(Road(0, 0, 0, -1))
    vis[0][0] = true
    while (queue.isNotEmpty()) {
        val road = queue.poll()
        val (x, y, price, dir) = road
        if (x == board.lastIndex && y == board.lastIndex) {
            for (i in 0 until 4){
                answer = min(answer, priceArr[i][x][y])
            }
        }

        for (i in 0 until 4) {
            var (nx, ny, nPrice, nDir) = intArrayOf(x + goX[i], y + goY[i], price, i)
            if (nx !in 0 until n || ny !in 0 until n) continue
            if (board[nx][ny]==1) continue
            if (dir == -1) nPrice += 100
            else if (dir != nDir) nPrice += 600
            else nPrice += 100

            if (!vis[nx][ny] || priceArr[nDir][nx][ny] >= nPrice) {
                vis[nx][ny] = true
                priceArr[nDir][nx][ny] = nPrice
                queue.add(Road(nx, ny, nPrice, nDir))
            }
        }
    }
}

data class Road(val x: Int, val y: Int, val price: Int, val dir: Int)


