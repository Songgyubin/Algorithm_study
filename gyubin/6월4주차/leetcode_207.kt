import java.util.LinkedList
import java.util.Queue
import javax.management.QueryEval

private fun main() {
    println(canFinish(2, arrayOf(intArrayOf(0, 1))))
}

private fun topologySort() {

}

private fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
    val inDegree = IntArray(numCourses)
    val arr = Array<ArrayList<Int>>(numCourses) { ArrayList() }
    prerequisites.forEach {
        val (a, b) = it
        inDegree[b]++
        arr[a].add(b)
    }
    val queue: Queue<Int> = LinkedList()

    for (i in 0 until numCourses) {
        if (inDegree[i] == 0) queue.add(i)
    }
    for (i in 0 until numCourses) {
        if (queue.isEmpty()) return false
        val a = queue.poll()
        for (j in 0 until arr[a].size) {
            val b = arr[a][j]
            inDegree[b]--
            if (inDegree[b] == 0) queue.add(b)
        }
    }
    return true
}
