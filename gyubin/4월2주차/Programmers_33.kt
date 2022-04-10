private lateinit var lion: IntArray
private lateinit var tmpAnswer: IntArray

private fun main() {
    solution(5, intArrayOf(2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0)).forEach {
        println(it)
    }
}

private fun solution(n: Int, info: IntArray): IntArray {
    var answer = ArrayList<Int>()
    // 어피치가 화살 n발을 다 쏜 후 라이언이 n 발 쏨
    // k점은 더많은 화살을 k점에 맞힌 선수가 k점 가져감
    // 단, 같은 확률이면 어피치가 k점 가져감
    // 최종 점수가 같을 경우 어피치가 우승자
    lion = IntArray(12)
    tmpAnswer = IntArray(12) { -1 }
    solve(0,n,info)
    if (tmpAnswer[0]==-1){
        return intArrayOf(-1)
    }
    for (i in 0 until 11) answer.add(tmpAnswer[i])
    return answer.toIntArray()
}

private fun cmp(a: IntArray, b: IntArray): Boolean {
    for (i in 11 downTo 0) {
        if (a[i] != b[i]) return a[i] > b[i]
    }
    return false
}

private fun solve(count: Int, left: Int, info: IntArray) {
    if (count == 10) {
        lion[count] = left
        var score = 0
        for (i in 0 until 11) {
            if (lion[i] > info[i]) score += (10 - i)
            else if (info[i] != 0) score -= (10 - i)
        }
        if (score <= 0) return
        lion[11] = score
        if (cmp(lion, tmpAnswer)) {
            for (i in 0 until 12) {
                tmpAnswer[i] = lion[i]
            }
        }
        return
    }
    for (i in 0..left) {
        lion[count] = i
        solve(count + 1, left - i, info)
    }
}