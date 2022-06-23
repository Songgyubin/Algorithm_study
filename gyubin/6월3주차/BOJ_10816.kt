import java.io.BufferedInputStream
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStream
import java.io.InputStreamReader
import java.io.OutputStreamWriter

private fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = br.readLine().toInt()
    val arr = br.readLine().split(" ").map { it.toInt() }.sorted().toIntArray()
    val m = br.readLine().toInt()
    br.readLine().split(" ").map { it.toInt() }.forEach {
        bw.append("${upperBound(arr, it) - lowerBound(arr, it)} ")
    }
    bw.flush()
    bw.close()
}

private fun lowerBound(arr: IntArray, target: Int): Int {
    var low = 0
    var high = arr.size
    while (low < high) {
        val mid = (low + high) / 2
        if (arr[mid] < target) {
            low = mid + 1
        } else if (arr[mid] >= target) {
            high = mid
        }
    }
    return low
}

private fun upperBound(arr: IntArray, target: Int): Int {
    var low = 0
    var high = arr.size
    while (low < high) {
        val mid = (low + high) / 2
        if (arr[mid] <= target) {
            low = mid + 1
        } else if (arr[mid] > target) {
            high = mid
        }
    }
    return high
}