private fun main() {

    println(solution("3people unFollowed me"))
}

private fun solution(s: String): String {
    var answer = ""
    s.split(" ").map { it.toLowerCase() }.forEachIndexed { index, tmp ->
        tmp.forEachIndexed { i, c ->
            if (i == 0) answer += c.toUpperCase()
            else answer += c
        }
        if (index != s.split(" ").lastIndex) answer += " "
    }
    return answer
}
