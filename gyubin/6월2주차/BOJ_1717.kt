private lateinit var nums: IntArray
private fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    nums = IntArray(n + 1) { it }
    for (i in 0 until m) {
        // 0: union, find: 1 a b
        val (type, a, b) = readln().split(" ").map { it.toInt() }
        if (type == 0) {
            union(a,b)
        } else {
            if (isContains(a, b)) println("YES")
            else println("NO")
        }
    }
}
private fun find(x: Int): Int {
    if (nums[x] == x) return x
    nums[x] = find(nums[x])
    return nums[x]
}

private fun union(x: Int, y: Int) {
    val findX = find(x)
    val findY = find(y)
    if (findX == findY) return
    if (nums[findY] < nums[findX]) nums[findX] = findY
    else nums[findY] = findX
}

private fun isContains(x: Int, y: Int): Boolean = find(x) == find(y)