import kotlin.math.max

private fun main() {
    println(longestConsecutive(intArrayOf(100,4,200,1,3,2)))
    println(longestConsecutive(intArrayOf(0,3,7,2,5,8,4,6,0,1)))
}
// 128. Longest Consecutive Sequence
private fun longestConsecutive(nums: IntArray): Int {
    if (nums.isEmpty()) return 0
    val a = nums.sorted().distinct()
    var pre = a[0]
    var answer = 0
    var tmpAnswer = 1
    for (i in 1 until a.size) {
        if (++pre==a[i]){
            tmpAnswer++
            continue
        }
        answer = max(answer,tmpAnswer)
        tmpAnswer = 1
        pre = a[i]
    }
    answer = max(answer,tmpAnswer)
    return answer
}