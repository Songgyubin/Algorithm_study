import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

// 숫자 카드

private fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = br.readLine().toInt()
    val arr = br.readLine().split(" ").map { it.toInt() }.sorted()
    val m = br.readLine().toInt()
    val cards = br.readLine().split(" ").map { it.toInt() }

    for (i in 0 until cards.size) {
        if (!binarySearch(arr, cards[i])) bw.append("0 ")
        else bw.append("1 ")
    }

    bw.flush()
    bw.close()
}

private fun binarySearch(arr: List<Int>, card: Int): Boolean {
    var left = 0
    var right = arr.lastIndex

    while (left <= right) {
        val mid = (left + right) / 2
        if (card == arr[mid]) return true
        else if (card < arr[mid]) right = mid-1
        else left = mid+1
    }
    return false
}