import kotlin.math.max
import kotlin.math.min

// Insert Interval

private fun main() {
    insert(arrayOf(intArrayOf(1, 3), intArrayOf(6, 9)), intArrayOf(2, 5)).forEach {
        println(it.joinToString(" "))
    }
}

private fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
    val answer = mutableListOf<IntArray>()
    val arr = BooleanArray(intervals.size)
    var index = 0

    var newStart = newInterval[0]
    var newEnd = newInterval[1]
    while (index < intervals.size && intervals[index][1] < newStart) {
        answer.add(intervals[index++])
    }

    while (index < intervals.size && intervals[index][0] <= newEnd) {
        newStart = min(intervals[index][0], newStart)
        newEnd = max(intervals[index][1], newEnd)
        index++
    }
    answer.add(intArrayOf(newStart, newEnd))
    while (index<intervals.size) answer.add(intervals[index++])

    return answer.toTypedArray()
}