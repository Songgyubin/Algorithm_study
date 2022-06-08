private lateinit var parentCities: IntArray
private fun main() {
    // 도시 n 개
    // 도시들 간의 연결 여부
    val n = readln().toInt()
    val m = readln().toInt()
    parentCities = IntArray(n+1){it}
    for (i in 1..n) {
        val cities = readln().split(" ").map { it.toInt() }
        for (j in i..n) {
            if (cities[j - 1] == 0) continue
            union(i, j)
        }
    }
    val travelPlan = readln().split(" ").map { it.toInt() }.toIntArray()
    for (i in 0 until travelPlan.size-1) {
        if (!isConnected(travelPlan[i], travelPlan[i+1])) {
            println("NO")
            return
        }
    }
    println("YES")

}

private fun find(x: Int): Int {
    if (x == parentCities[x]) return x
    parentCities[x] = find(parentCities[x])
    return parentCities[x]
}

private fun union(x: Int, y: Int) {
    val parentX = find(x)
    val parentY = find(y)
    if (parentX == parentY) return
     parentCities[parentY] = parentX
}

private fun isConnected(x: Int, y: Int): Boolean = find(x) == find(y)