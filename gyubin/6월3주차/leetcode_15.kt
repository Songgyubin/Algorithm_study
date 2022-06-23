private fun main() {

    println(threeSum(intArrayOf(-1, 0, 1, 2, -1, -4)).joinToString(" "))

}



private fun threeSum(nums: IntArray): List<List<Int>> {
    val answerArr = hashSetOf<List<Int>>()
    nums.sort()
    for (first in 0 until nums.size-2) {
        var second = first + 1
        var third = nums.lastIndex

        while (second < third) {
            val sum = nums[first] + nums[second] + nums[third]
            if (sum == 0) {
                answerArr.add(listOf(nums[first], nums[second++], nums[third--]))
            } else if (sum < 0) second++
            else third--
        }

    }
    return answerArr.toList()
}

