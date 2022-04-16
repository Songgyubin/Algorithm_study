import kotlin.math.max

private var tmpAnswer = 0
private lateinit var arr: IntArray
private lateinit var vis: BooleanArray
private fun main() {

    println(solution(80, arrayOf(intArrayOf(80, 20), intArrayOf(50, 40), intArrayOf(30, 10))))
}

private fun solution(k: Int, dungeons: Array<IntArray>): Int {
    var answer: Int = -1
    // 최소 필요 피로도: 탐험 시작 시 필요
    // 소모 피로도: 탐험이 끝난 후 피로도
    // k: 현재 피로도 dungeons: 최소 필요 피로도 / 소모 피로도
    arr = IntArray(dungeons.size)
    vis = BooleanArray(dungeons.size)
    solve(0, k, dungeons)
    answer = tmpAnswer
    return answer
}

// 순서만 뽑기
private fun solve(count: Int, k: Int, dungeons: Array<IntArray>) {
    if (count == dungeons.size) {
        goDungeons(k, arr, dungeons)
        return
    }
    for (i in dungeons.indices) {
        if (vis[i]) continue
        vis[i] = true
        arr[count] = i
        solve(count + 1, k, dungeons)
        vis[i] = false
    }
}

// 더이상 진행 못한다면 tmpAnswer = max()로 하고 게임 끝
private fun goDungeons(k: Int, arr: IntArray, dungeons: Array<IntArray>) {
    var count = 0
    var hp = k
    for (i in arr.indices) {
        val tmp = arr[i]
        val required = dungeons[tmp][0]
        val consume = dungeons[tmp][1]
        if (hp >= required) {
            hp -= consume
            count += 1

        } else {
            break
        }
    }
    tmpAnswer = max(tmpAnswer, count)

}