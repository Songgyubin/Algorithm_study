import java.util.*
import kotlin.math.max

// Longest Substring Without Repeating Characters

private fun main() {
    println(lengthOfLongestSubstring("pwwkew"))
}

private fun lengthOfLongestSubstring(s: String): Int {
    var answer = 0
    val queue = LinkedList<Char>()
    if (s.length == 1) return 1
    for (i in 0 until s.length) {
        val c = s[i]
        if (queue.contains(c)) {
            val tmp = queue.indexOf(c)
            for (j in 0..tmp) queue.poll()
        }
        queue.add(c)
        answer = max(answer, queue.size)
    }
    return answer
}