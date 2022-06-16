private fun main() {

//    println(binarySearch(intArrayOf(17, 28, 43, 67, 88, 92, 100), 43))
    val n = readln().toInt()
    val arr = readln().split(" ").map { it.toInt() }.toIntArray()
    val m = readln().toInt()
    arr.sort()
    readln().split(" ").map { it.toInt() }.forEach {
        if (binarySearch(arr, it) != -1) println(1)
        else println(0)
    }
}

private fun binarySearch(nums: IntArray, target: Int): Int {
    val answer = -1

    var low = 0
    var high = nums.lastIndex

    while (low <= high) {
        val mid = (low + high) / 2

        if (nums[mid] < target) {
            low = mid + 1
        } else if (nums[mid] > target) {
            high = mid - 1
        } else {
            return mid
        }
    }

    return answer
}