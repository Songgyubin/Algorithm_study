private lateinit var gates: IntArray
private fun main() {
    gates = IntArray(readln().toInt() + 1) { it }
    var answer = 0
    for (i in 1..readln().toInt()) {
        val ableDockGate = find(readln().toInt())
        if (ableDockGate == 0) break
        answer = i
        union(ableDockGate, ableDockGate - 1)
    }
    println(answer)
}

private fun find(x: Int): Int {
    if (x == gates[x]) return x
    gates[x] = find(gates[x])
    return gates[x]
}

private fun union(x: Int, y: Int) {
    val findX = find(x)
    val findY = find(y)
    if (findX == findY) return
    gates[findX] = findY
}
