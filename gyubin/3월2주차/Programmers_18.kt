import java.lang.Integer.max
import java.util.*
import kotlin.collections.ArrayList

private fun main() {

    println(
        solution(
            6,
            arrayOf(
                intArrayOf(3, 6),
                intArrayOf(4, 3),
                intArrayOf(3, 2),
                intArrayOf(1, 3),
                intArrayOf(1, 2),
                intArrayOf(2, 4),
                intArrayOf(5, 2)
            )
        )
    )

}

private lateinit var arr: Array<ArrayList<Int>>
private lateinit var vis: BooleanArray
private lateinit var distance: IntArray
private var max = Int.MIN_VALUE

private fun solution(n: Int, edge: Array<IntArray>): Int {
    var answer =0
    // 1번 노드에서 가장 멀리 떨어진 노드의 갯수
    // 가장 멀리 떨어진 노드: 최단경로로 이동했을 때 간선의 개수가 가장 많은 노드들
    arr = Array(n) { ArrayList() }
    vis = BooleanArray(n)
    distance = IntArray(n)
    edge.forEach {
        arr[it[0] - 1].add(it[1] - 1)
        arr[it[1] - 1].add(it[0] - 1)
    }
    bfs(n)!!
    for (i in distance){
        if (i==max) answer++
    }

    return answer
}

private fun bfs(n: Int) {

    val queue: Queue<Int> = LinkedList()
    queue.add(0)
    vis[0] = true
    while (queue.isNotEmpty()) {
        val node = queue.poll()
        for (i in arr[node]) {
            if (!vis[i]) {
                vis[i] = true
                queue.add(i)
                distance[i] = distance[node] + 1
                max = max(max, distance[i])
            }
        }
    }
}