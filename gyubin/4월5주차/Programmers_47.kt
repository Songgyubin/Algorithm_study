import java.util.*

private lateinit var arr: Array<String>
private lateinit var vis: BooleanArray
private var tmpAnswer = mutableListOf<Pair<String, Int>>()
private var answer: SortedSet<String> = sortedSetOf()
private fun main() {
//    solution(arrayOf("ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"), intArrayOf(2, 3, 4))
//    solution(arrayOf("ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"), intArrayOf(2, 3, 5))
    solution(arrayOf("XYZ", "XWY", "WXA"), intArrayOf(2, 3, 4))
}

private fun solution(orders: Array<String>, course: IntArray): Array<String> {
    course.forEach { n ->
        arr = Array(n) { "" }
        orders.forEach { order ->
            vis = BooleanArray(order.length)
            makeCourse(n, 0, 0, order, orders)
        }
    }

    course.forEach { count ->
        val tmp =
            tmpAnswer.filter { it.first.length == count }
        var maxCount =0
                if (tmp.isNotEmpty()){
                       maxCount = tmp.maxOf { it.second }
                }

        tmpAnswer.filter { it.first.length == count }.filter { it.second == maxCount }.forEach {
            answer.add(it.first)
        }
    }

    return answer.toTypedArray().sortedArray()
}

private fun makeCourse(n: Int, count: Int, start: Int, order: String, orders: Array<String>) {
    if (n == count) {
        addOrder(arr.joinToString(""), orders, n)
        return
    }
    for (i in start until order.length) {
        if (vis[i]) continue
        vis[i] = true
        arr[count] = order[i].toString()
        makeCourse(n, count + 1, i + 1, order, orders)
        vis[i] = false
    }
}

private fun addOrder(tmpOrder: String, orders: Array<String>, n: Int) {

    var totalCount = 0
    orders.forEach {
        var orderCount = 0
        it.forEach { order ->
            tmpOrder.forEach { tmp ->
                if (order == tmp) {
                    orderCount += 1
                }
            }
        }
        if (orderCount == n) totalCount += 1
    }
    if (totalCount >= 2) {
        tmpAnswer.add(Pair(tmpOrder.toSortedSet().joinToString(""), totalCount))
    }

}