import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.min

private fun main() {

}

private lateinit var edges: Array<ArrayList<Edge>>
private fun solution(n: Int, s: Int, a: Int, b: Int, fares: Array<IntArray>): Int {
    var answer: Int = Int.MAX_VALUE
    edges = Array(n + 1) { ArrayList() }
    for (i in 0 until fares.size) {
        val (start, target, dist) = fares[i]

        edges[start].add(Edge(target, dist))
        edges[target].add(Edge(start, dist))
    }
    val distS = dijkstra(n, s)
    val distA = dijkstra(n, a)
    val distB = dijkstra(n, b)
    for (i in 1..n) {
        answer = min(answer, distS[i] + distA[i] + distB[i])
    }
    return answer
}

private fun dijkstra(n: Int, start: Int): IntArray {
    val dist = IntArray(n + 1) { Int.MAX_VALUE }
    val pq = PriorityQueue<Info>()
    dist[start] = 0
    pq.add(Info(start, dist[start]))
    while (pq.isNotEmpty()) {
        val info = pq.poll()
        if (info.dist > dist[info.node]) continue
        for (edge in edges[info.node]) {
            if (edge.dist + dist[info.node] > dist[edge.to]) continue
            dist[edge.to] = edge.dist + dist[info.node]
            pq.add(Info(edge.to,dist[edge.to]))
        }
    }
    return dist
}

data class Edge(val to: Int, val dist: Int)
data class Info(val node: Int, val dist: Int) : Comparable<Info> {
    override fun compareTo(other: Info): Int = this.dist - other.dist
}