import kotlin.math.max

private fun main() {
    println(maxProduct(intArrayOf(-2, 3, -4))) //24
    println(maxProduct(intArrayOf(2, -5, -2, -4, 3))) //24
}

private fun maxProduct(nums: IntArray): Int {

    var answer = Int.MIN_VALUE
    var tmp = 1
    var containZero = false

    for (i in 0 until nums.size) {
        val num = nums[i]
        if (num == 0) {
            containZero = true
            tmp = 1
            continue
        }
        tmp *= num
        answer = max(answer, tmp)
    }
    tmp = 1
    for (i in nums.lastIndex downTo 0){
        val num = nums[i]
        if (num == 0) {
            containZero = true
            tmp = 1
            continue
        }
        tmp *= num
        answer = max(answer, tmp)
    }


    if (containZero && answer < 0) return 0
    return answer
}