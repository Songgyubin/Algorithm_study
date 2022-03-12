import java.util.*

private fun main() {
//    println(solution(3, arrayOf(intArrayOf(1, 1, 0), intArrayOf(1, 1, 0), intArrayOf(0, 0, 1)))) // 2
    println(solution(3, arrayOf(intArrayOf(1, 1, 0), intArrayOf(1, 1, 1), intArrayOf(0, 1, 1)))) // 1
}

private lateinit var vis: BooleanArray

//private fun solution(n: Int, computers: Array<IntArray>): Int = bfs(n, computers)
private fun solution(n: Int, computers: Array<IntArray>): Int {
    var answer = 0
    val visited = BooleanArray(n)

    for (i in 0 until n) {
        if (visited[i]) continue
        answer++
        dfs(visited, computers, i)
    }
    return answer
}

private fun bfs(n: Int, computers: Array<IntArray>): Int {
    var answer = 0
    vis = BooleanArray(n)
    val queue = LinkedList<IntArray>()
    for (i in 0 until n) {
        if (vis[i]) continue
        queue.add(computers[i])
        vis[i] = true
        while (queue.isNotEmpty()) {
            val q = queue.poll()
            for (j in q.indices) {
                if (!vis[j] && q[j] == 1) {
                    queue.add(computers[j])
                    vis[j] = true
                }
            }
        }
        answer++
    }
    return answer
}

private fun dfs(vis: BooleanArray, computers: Array<IntArray>, index: Int) {
    vis[index] = true
    for (i in computers.indices) {
        if (!vis[i] && computers[index][i] == 1)
            dfs(vis, computers, i)
    }
}