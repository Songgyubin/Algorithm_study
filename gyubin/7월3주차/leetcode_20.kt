import java.util.Stack

private fun main() {

}

// Valid Parentheses
private fun isValid(s: String): Boolean {
    val stack = Stack<Char>()
    if (s.length%2!=0) return false
    s.forEach {
        if (it == '(' || it == '{' || it == '[') stack.push(it)
        else {
            if (stack.isEmpty()) return false
            val a = stack.pop()
            when (it) {
                ')' -> {
                    if (a != '(') return false
                }
                '}' -> {
                    if (a != '{') return false
                }
                ']' -> {
                    if (a != '[') return false
                }
            }
        }
    }
    if (stack.isNotEmpty()) return false
    return true
}
