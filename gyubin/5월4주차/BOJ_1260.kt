import java.util.LinkedList
import java.util.Queue

private lateinit var vis: BooleanArray
private lateinit var arr: Array<ArrayList<Int>>
private lateinit var answer: MutableList<Int>
private fun main() {
    // 방문할 수 있는 정점이 여러 개인 경우
    // 정점 번호가 작은 것을 먼저 방문
    // 더 이상 방문할 수 있는 점이 없으면 종료

    val (n, m, v) = readln().split(" ").map { it.toInt() }
    vis = BooleanArray(n)
    arr = Array(n) { ArrayList() }
    answer = mutableListOf()
    for (i in 0 until m) {
        val (a, b) = readln().split(" ").map { it.toInt() - 1 }
        arr[a].add(b)
        arr[b].add(a)
    }
    arr.map { it.sort() }

    dfs(v - 1)
    println(answer.map { it + 1 }.joinToString(" "))

    vis = BooleanArray(n)
    answer = mutableListOf()
    bfs(v - 1)
    println(answer.map { it + 1 }.joinToString(" "))

}

private fun bfs(start: Int) {

    val queue: Queue<Int> = LinkedList<Int>()
    queue.add(start)
    while (queue.isNotEmpty()) {
        val x = queue.poll()
        answer.add(x)
        vis[x] = true
        for (i in 0 until arr[x].size) {
            val xx = arr[x][i]
            if (vis[xx]) continue
            vis[xx] = true
            queue.add(xx)
        }
    }
}

private fun dfs(start: Int) {
    if (vis[start]) return
    vis[start] = true
    answer.add(start)
    for (i in 0 until arr[start].size) {
        val x = arr[start][i]
        if (vis[x]) continue
        dfs(x)
    }
}