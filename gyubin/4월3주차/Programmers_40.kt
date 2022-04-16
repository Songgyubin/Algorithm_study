import java.util.*
import kotlin.math.sqrt

private fun main() {

    println(solution(437674, 3))
//    println(solution(110011, 10))
//    println(solution(10,10))
}

private fun solution(n: Int, k: Int): Int {
    var answer: Int = 0
    //p는 소수
    // 0p0
    // p0
    // 0p
    // p
    var num = convertToJinSoo(n, k)
    if (num.length == 1) {
        return if (isPrime(num)) 1
        else 0
    }
    answer = num.split("0").count { isPrime(it) }
    return answer
}

private fun convertToJinSoo(num: Int, k: Int): String {
    var tmpNum = num
    val stack = Stack<Int>()
    var result = ""
    while (true) {
        stack.push(tmpNum % k)
        tmpNum /= k
        if (tmpNum < k) {
            stack.push(tmpNum % k)
            break
        }
    }
    for (i in stack.indices) {
        result += stack.pop()
    }
    return result
}

private fun isPrime(s: String): Boolean {
    var num = 0L
    val tmp = s.filter { it != '0' }.toCharArray().joinToString("")
    if (tmp.isEmpty()) return false
    else num = tmp.toLong()
        if (s == "1") return false
    for (i in 2 .. sqrt(num.toDouble()).toInt()) {
        if (num % i == 0L) return false
    }
    return true
}