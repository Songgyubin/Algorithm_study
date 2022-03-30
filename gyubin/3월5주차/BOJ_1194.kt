import java.util.*

private val goX = intArrayOf(1, -1, 0, 0)
private val goY = intArrayOf(0, 0, 1, -1)
private lateinit var vis: Array<Array<BooleanArray>>
private lateinit var arr: Array<CharArray>

private fun main() {

    // . 빈칸 항상 이동가능
    // # 절대 이동 불가
    // 열쇠 항상 이동가능
    // 문 열쇠가 있을 때만
    // 0 민식이 현재위치
    // 출구 1 도착시 미로 탈출 : 1이 여러 개일수도
    var answer = Int.MAX_VALUE
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    arr = Array(n) { CharArray(m) }
    vis = Array(64) { Array(n) { BooleanArray(m) } }

    var start = Node(0, 0, 0, 0)
    for (i in 0 until n) {
        val tmp = readLine()!!.toCharArray()
        arr[i] = tmp
        if (tmp.contains('0')) start = Node(i, tmp.indexOf('0'), 0, 0)
    }
    println(bfs(start, n, m))

}

private fun bfs(start: Node, n: Int, m: Int): Int {
    val queue = LinkedList<Node>()
    queue.add(Node(start.x, start.y, start.count, start.key))
    vis[0][start.x][start.y] = true

    while (queue.isNotEmpty()) {
        val (x, y, count, key) = queue.poll()
        if (arr[x][y] == '1') return count

        for (i in 0 until 4) {
            val (nX, nY) = intArrayOf(x + goX[i], y + goY[i])
            if (nX !in 0 until n || nY !in 0 until m) continue
            if (vis[key][nX][nY]) continue
            if (arr[nX][nY] == '#') continue
            if (arr[nX][nY] == '.' || arr[nX][nY] == '0' || arr[nX][nY] == '1') {
                vis[key][nX][nY] = true
                queue.add(Node(nX, nY, count + 1, key))
            } else if (arr[nX][nY] in 'a'..'f') {
                var newKey = 1 shl (arr[nX][nY] - 'a')
                newKey = newKey or key
                if (vis[newKey][nX][nY]) continue
                vis[key][nX][nY] = true
                vis[newKey][nX][nY] = true
                queue.add(Node(nX, nY, count + 1, newKey))
            } else if (arr[nX][nY] in 'A'..'F') {
                val door = 1 shl arr[nX][nY] - 'A'
                if ((key and door) > 0) {
                    vis[key][nX][nY] = true
                    queue.add(Node(nX, nY, count + 1, key))
                }
            }

        }
    }
    return -1
}

private data class Node(val x: Int, val y: Int, val count: Int, val key: Int)