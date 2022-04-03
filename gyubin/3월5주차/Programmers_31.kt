import java.util.*

private fun main() {
    println(solution(arrayOf(intArrayOf(0, 3), intArrayOf(1, 9), intArrayOf(2, 6))))
}


private fun solution(jobs: Array<IntArray>): Int {
    var answer = 0
    val sortedJobs = jobs.sortedWith(kotlin.Comparator { o1, o2 -> o1[0] - o2[0] })
    val priorityQueue = PriorityQueue<IntArray> { o1, o2 -> o1[1] - o2[1] }

    var endTime = 0
    var count = 0
    var index = 0
    while (count < sortedJobs.size) {
        while (index < sortedJobs.size && sortedJobs[index][0] <= endTime) {
            println(endTime)
            priorityQueue.add(sortedJobs[index++])
        }

        if (priorityQueue.isEmpty()) {
            endTime = sortedJobs[index][0]
        } else {
            val tmp = priorityQueue.poll()
            answer += tmp[1] + endTime - tmp[0]
            endTime += tmp[1]
            count++
        }
    }

    return answer / sortedJobs.size
}
