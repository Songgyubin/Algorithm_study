private fun main() {

}

private fun findDisappearedNumbers(nums: IntArray): List<Int> {
    val answer = mutableListOf<Int>()
    val size = nums.size
    val arr = nums.sorted().toIntArray()
    for (i in 1..size) {
        if (!binarySearch(arr,i)) answer.add(i)
    }
    return answer
}

private fun binarySearch(arr: IntArray, target: Int): Boolean {
    var left = 0
    var right = arr.lastIndex
    while (left <= right) {
        val mid = (left + right) / 2
        if (arr[mid] == target) return true
        else if (arr[mid] < target) left = mid+1
        else right = mid-1
    }
    return false
}