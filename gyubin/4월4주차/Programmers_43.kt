private fun main() {
    println(
        solution(
            arrayOf("frodo", "front", "frost", "frozen", "frame", "kakao"),
            arrayOf("fro??", "????o", "fr???", "fro???", "pro?")
        ).joinToString(",")
    )
}
private fun solution(words: Array<String>, queries: Array<String>): IntArray {
    val frontMap: MutableMap<Int, MutableList<String?>> = HashMap()
    val backMap: MutableMap<Int, MutableList<String?>> = HashMap()

    for (word: String in words) {
        val len = word.length
        frontMap.computeIfAbsent(len,
            { i: Int? -> ArrayList() }).add(word)
        backMap.computeIfAbsent(len,
            { i: Int? -> ArrayList() }).add(word.reversed())
    }

    for (key: Int in frontMap.keys) {
        frontMap[key]!!.sortBy { it }
        backMap[key]!!.sortBy { it }
    }

    val answer: MutableList<Int> = ArrayList()
    for (i in queries.indices) {
        var query = queries[i]
        var list: List<String?>?
        if (query[0] == '?') {
            list = backMap[query.length]
            query = query.reversed()
        } else list = frontMap[query.length]
        if (list == null) answer.add(0) else answer.add(
            lowerBound(list, query.replace('?', Character.MAX_VALUE))
                    - lowerBound(list, query.replace("?", ""))
        )
    }

    return answer.toIntArray()
}

private fun lowerBound(list: List<String?>, str: String): Int {
    var s = 0
    var e = list.size
    while (s < e) {
        val m = (s + e) / 2
        if (str.compareTo(list[m]!!) <= 0) e = m else s = m + 1
    }
    return s
}