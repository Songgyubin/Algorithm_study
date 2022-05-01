import java.util.*

private fun main() {
    println(solution("1924", 2))
}

private fun solution(number: String, k: Int): String {
    var stack = Stack<Char>()
    var count = k
    stack.add(number[0])
    for (i in 1 until number.length) {
        while (stack.isNotEmpty() && stack.peek() < number[i]) {
            stack.pop()
            count -= 1
            if (count==0) break
        }
        stack.push(number[i])
    }
    return stack.take(stack.size-count).map { it.toString() }.joinToString("")
}
