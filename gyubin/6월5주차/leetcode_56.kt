import kotlin.math.max
import kotlin.math.min

//Merge Intervals

private fun main() {
    merge(arrayOf(intArrayOf(1, 3), intArrayOf(2, 6), intArrayOf(8, 10), intArrayOf(15, 18))).forEach {
        println(it.joinToString(" "))
    }
}

private fun merge(intervals: Array<IntArray>): Array<IntArray> {
    var answer = mutableListOf<IntArray>()

    val sortedIntervals = intervals.sortedBy { it[0] }
    var start = sortedIntervals[0][0]
    var end = sortedIntervals[0][1]

    for (i in 1 until sortedIntervals.size) {
        val interval = sortedIntervals[i]
        val (newStart, newEnd) = interval
        if (newStart <= end) {
            start = min(start, newStart)
            end = max(end, newEnd)
        } else {
            answer.add(intArrayOf(start, end))
            start = newStart
            end = newEnd
        }
    }
    answer.add(intArrayOf(start, end))

    return answer.toTypedArray()
}