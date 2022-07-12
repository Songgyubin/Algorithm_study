import java.util.*


private fun main() {
    groupAnagrams(arrayOf("eat", "tea", "tan", "ate", "nat", "bat")).forEach {
        println(it.joinToString(" "))
    }
}

private fun groupAnagrams(strs: Array<String>): List<List<String>> {
    if (strs.isEmpty()) return listOf(listOf(""))
    else if (strs.size == 1) return listOf(strs.toList())

    val strsHash = HashMap<String, MutableList<String>>()
    strs.forEach {
        val s = it.toCharArray().sorted().toString()
        if (strsHash.containsKey(s)) strsHash[s]!!.add(it)
        else strsHash.computeIfAbsent(s){ mutableListOf<String>() }.add(it)
    }
    val answer = mutableListOf<MutableList<String>>()
    strsHash.forEach {
        answer.add(it.value)
    }

    return answer
}

private fun isAnagram(key: String, target: String): Boolean {
    val alphabet = IntArray(26)
    key.forEach { alphabet[it - 'a']++ }
    target.forEach { alphabet[it - 'a']-- }

    alphabet.forEach { if (it != 0) return false }

    return true
}