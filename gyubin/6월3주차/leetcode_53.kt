import kotlin.math.max

private fun main() {
    println(maxSubArray(intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)))
}

private fun maxSubArray(nums: IntArray): Int {
    if (nums.size == 1) return nums[0]
    var answer = dividedSum(nums, 0, nums.lastIndex)
    return answer
}

private fun dividedSum(nums: IntArray, low: Int, high: Int): Int {
    if (low == high) return nums[low]

    val mid = (low + high) / 2
    var answer = 0

    var sum = 0
    var leftSum = Int.MIN_VALUE
    for (i in mid downTo low) {
        sum += nums[i]
        leftSum = max(leftSum, sum)
    }
    sum = 0
    var rightSum = Int.MIN_VALUE
    for (i in mid+1 .. high) {
        sum += nums[i]
        rightSum = max(rightSum, sum)
    }
    answer = max(dividedSum(nums, low, mid), dividedSum(nums, mid + 1, high))
    answer = max(leftSum+rightSum, answer)
    return answer
}