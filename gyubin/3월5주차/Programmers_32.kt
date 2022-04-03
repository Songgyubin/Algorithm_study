import java.util.*
import kotlin.collections.HashMap

private fun main() {
    println(
        solution(
            arrayOf(
                "DIA",
                "RUBY",
                "RUBY",
                "DIA",
                "DIA",
                "EMERALD",
                "SAPPHIRE",
                "DIA"
            )
        ).joinToString(" ")
    ) // 3 7
    println(solution(arrayOf("A", "B", "B", "B", "B", "B", "B", "C", "B", "A")).joinToString(" ")) // 8 10

}

private fun solution(gems: Array<String>): IntArray {
    var answer = intArrayOf()
    // 특정 범위의 보석을 모두 구매하되
    // 진열된 모든 종류의 보석을 적어도 1개 이상 포함하는 가장 짧은 구간을 찾아서 구매
    val deduplicatedGems = gems.distinct()

    val count = deduplicatedGems.size
    if (count == 1) return intArrayOf(1, 1)

    // gem / size
    val hash = HashMap<String, Int>()
    var startPoint = 0
    var len = Int.MAX_VALUE
    val queue = LinkedList<String>()

    var start = 0
    for (element in gems) {
        hash[element] = hash.getOrDefault(element, 0) + 1
        queue.add(element)
        while (true) {
            val tmpGem = queue.peek()
            if (hash[tmpGem]!! > 1) {
                queue.poll()
                startPoint++
                hash[tmpGem] = hash[tmpGem]!! - 1
            } else break
        }
        if (hash.keys.size == count && len > queue.size) {
                len = queue.size
                start = startPoint
        }
    }
    return intArrayOf(start + 1, start + len)
}