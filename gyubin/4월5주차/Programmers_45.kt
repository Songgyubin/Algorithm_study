import kotlin.math.max

private fun main() {

    println(
        solution(
            intArrayOf(0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1),
            arrayOf(
                intArrayOf(0, 1),
                intArrayOf(1, 2),
                intArrayOf(1, 4),
                intArrayOf(0, 8),
                intArrayOf(8, 7),
                intArrayOf(9, 10),
                intArrayOf(9, 11),
                intArrayOf(4, 3),
                intArrayOf(6, 5),
                intArrayOf(4, 6),
                intArrayOf(8, 9)
            )
        )
    )

}

private var answer = 0
private lateinit var nodes: HashMap<Int, ArrayList<Int>>

private fun solution(info: IntArray, edges: Array<IntArray>): Int {


    // 0: 양
    // 1: 늑대
    // 부모, 자식들
    nodes = HashMap<Int, ArrayList<Int>>()
    edges.forEach {
        val (parent, child) = it
        nodes.computeIfAbsent(parent) { ArrayList() }.add(child)
    }

    // count가 -1이면 return
    val nextNodes = ArrayList<Int>()
    nextNodes.add(0)
    dfs(0, 0, 0, nextNodes, info)


    return answer
}

private fun dfs(sheep: Int, count: Int, node: Int, nextNodes: ArrayList<Int>, info: IntArray) {
    var tmpCount = count
    var tmpSheep = sheep
    if (info[node] == 0) {
        tmpSheep += 1
        tmpCount += 1
    } else tmpCount -= 1

    answer = max(answer, tmpSheep)

    if (tmpCount <= 0) return

    val copied = ArrayList<Int>()
    copied.addAll(nextNodes)

    if (nodes[node]?.isNotEmpty() == true) copied.addAll(nodes[node]!!)

    copied.remove(node)

    for (i in copied) {
        dfs(tmpSheep, tmpCount, i, copied, info)
    }
}