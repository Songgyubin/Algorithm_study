import java.util.LinkedList
import java.util.Queue

private fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }

    val inDegree = IntArray(n + 1)
    val arr = Array<ArrayList<Int>>(n + 1) { ArrayList() }
    val result = ArrayList<Int>()
    for (i in 0 until m) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        inDegree[b]++
        arr[a].add(b)
    }
    val queue: Queue<Int> = LinkedList()

    for (i in 1..n) {
        if (inDegree[i] == 0) queue.add(i)
    }
    for (i in 1..n) {
        if (queue.isEmpty()) break
        val a = queue.poll()
        result.add(a)
        for (j in 0 until arr[a].size) {
            val b = arr[a][j]
            inDegree[b]--
            if (inDegree[b] == 0) queue.add(b)
        }
    }
    println(result.joinToString(" "))
}
