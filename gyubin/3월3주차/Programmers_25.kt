import kotlin.math.min

private fun main() {
    println(solution("hit", "cog", arrayOf("hot", "dot", "dog", "lot", "log", "cog")))
}

private var answer = Int.MAX_VALUE
private lateinit var wordsVis: BooleanArray
private fun solution(begin: String, target: String, words: Array<String>): Int {

    if (!words.contains(target)) return 0
    wordsVis = BooleanArray(words.size)
    dfs(begin, target, words, 0)

    return answer
}

private fun dfs(begin: String, target: String, words: Array<String>, depth: Int) {
    if (begin == target) {
        answer = min(answer, depth)
        return
    }
    for (i in words.indices) {
        if (wordsVis[i]) continue
        val word = words[i]
        var k = 0
        for (j in begin.indices) {
            if (begin[j] == word[j]) {
                k++
            }
        }
        if (k == begin.length - 1) {
            wordsVis[i] = true
            dfs(words[i], target, words, depth + 1)
            wordsVis[i] = false
        }

    }
}