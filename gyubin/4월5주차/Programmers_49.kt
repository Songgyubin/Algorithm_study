private lateinit var arr: CharArray
private lateinit var vis: BooleanArray
private lateinit var expressionPriority: ArrayList<String>

private fun main() {
    println(solution("100-200*300-500+20"))
}

private fun solution(expression: String): Long {
    var answer: Long = 0
    val expressionList = expression.filter { !it.isDigit() }.toSortedSet().toList()
    vis = BooleanArray(expressionList.size)
    arr = CharArray(expressionList.size)
    expressionPriority = ArrayList()

    combinationExpression(expressionList.size, 0, expressionList)
    val numOrder = expression.split('*', '-', '+').map { it.toLong() }
    val opsOrder = expression.filter { it in "*+-" }
    expressionPriority.forEach { ops ->

        val tempNums = numOrder.toMutableList()
        val tempOps = opsOrder.toMutableList()
        ops.forEach { op ->
            var index = tempOps.indexOfFirst { it == op }

            while (index >= 0) {
                val result = when (op) {
                    '*' -> tempNums[index] * tempNums[index + 1]
                    '+' -> tempNums[index] + tempNums[index + 1]
                    '-' -> tempNums[index] - tempNums[index + 1]
                    else -> 0
                }
                tempNums[index + 1] = result
                tempNums.removeAt(index)
                tempOps.removeAt(index)
                index = tempOps.indexOfFirst { it == op }
            }
        }
        answer = answer.coerceAtLeast(Math.abs(tempNums[0]))
    }

    return answer
}

private fun combinationExpression(n: Int, count: Int, expressions: List<Char>) {
    if (n == count) {
        expressionPriority.add(arr.joinToString(""))
        return
    }
    for (i in 0 until n) {
        if (vis[i]) continue
        vis[i] = true
        arr[count] = expressions[i]
        combinationExpression(n, count + 1, expressions)
        vis[i] = false
    }

}