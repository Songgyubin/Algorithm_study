import java.util.*

private fun main() {
// 중요도 확인
    // 나머지 문서들 중 현재 문서보다 중요도가 높은 문서가 하나라도 있으면
    // 가장 뒤에 배치
    // 아니면 바로인쇄
// n: 문서의 개수
    // m: 정답을 찾는 것
    val t = readLine()!!.toInt()
    var testCaseCount = 0

    while (testCaseCount < t) {
        testCaseCount += 1
        val (n, m) = readLine()!!.split(" ").map { it.toInt() }
        var count = 0
        // 문서 번호, 중요도
        val tmp = readLine()!!.split(" ").map { it.toInt() }
        val queue = LinkedList<Pair<Int, Int>>()

        tmp.forEachIndexed { index, priority ->
            queue.offer(Pair(index, priority))
        }
        while (queue.isNotEmpty()) {
            val tmpQueue = queue.poll()
            var isMaximum = true

            for (i in 0 until queue.size) {
                if (tmpQueue.second < queue[i].second) {
                    queue.offer(tmpQueue)
                    for (j in 0 until i) {
                        queue.offer(queue.poll())
                    }
                    isMaximum = false
                    break
                }
            }
            if (!isMaximum) continue
            count++
            if (tmpQueue.first == m) break
        }
        println(count)
    }

}
