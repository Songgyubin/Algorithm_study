import java.util.*

private lateinit var arr: CharArray
private lateinit var list: ArrayList<String>

private fun main() {
    solution("I")
}

private fun solution(word: String): Int {
    list = ArrayList()
    val dictionary = "AEIOU"
    for (i in 1..dictionary.length) {
        arr = CharArray(i)
        makeWords(i, 0, dictionary)
    }
    list.forEach {
        println(it)
    }

    return list.sorted().indexOf(word)+1
}

private fun makeWords(n: Int, count: Int, dictionary: String) {
    if (n == count) {
        list.add(arr.joinToString(""))
        return
    }
    for (element in dictionary) {
        arr[count] = element
        makeWords(n, count + 1, dictionary)
    }

}