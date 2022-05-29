import kotlin.concurrent.fixedRateTimer
import kotlin.math.min

private fun main() {
    println(solution(12, intArrayOf(1, 5, 6, 10), intArrayOf(1, 2, 3, 4)))
//    solution(12, intArrayOf(0, 1, 2, 3), intArrayOf(4, 5, 6, 7))
}

private lateinit var visFriends: BooleanArray
private lateinit var friendArr: IntArray
private lateinit var overWeak: IntArray

private var answer = Int.MAX_VALUE
private fun solution(n: Int, weak: IntArray, dist: IntArray): Int {
    // 레스토랑의 정북 방향 지점: 0
    // 취약 지점의 위치는 정북 방향 지점으로부터 시계 방향으로 떨어진 거리
    // 친구들은 출발 지점부터 시계, 혹은 반시계 방향으로 외벽을 따라서만 이동
    // 외벽의 길이 n, 취약 지점 위치 배열 weak, 1시간 동안 이동할 수 있는 거리 dist
    // 취약 지점 위치: 오름 차순 정렬
    visFriends = BooleanArray(dist.size)
    setOverWeak(weak,n)


    for (i in 1..dist.size) {
        friendArr = IntArray(i)
        selectFriend(dist.sortedDescending().toIntArray(), i, 0,weak)
    }

    if (answer == Int.MAX_VALUE) return -1
    else return answer
}

private fun setOverWeak(weak: IntArray,n:Int) {
    overWeak = IntArray(weak.size * 2)
    for (i in 0 until weak.size) overWeak[i] = weak[i]
    for (j in weak.size until weak.size * 2) overWeak[j] = weak[j - weak.size] + n
}

private fun selectFriend(dist: IntArray, maxCount: Int, count: Int, weak: IntArray) {
    if (maxCount == count) {
        answer = min(answer, inspectWall(weak))
        return
    }
    for (i in count until dist.size) {
        if (visFriends[i]) continue
        visFriends[i] = true
        friendArr[count] = dist[i]
        selectFriend(dist, maxCount, count + 1,weak)
        visFriends[i] = false
    }

}

private fun inspectWall(weak: IntArray): Int {
    var cur = 0
    var next = 0
    var friendIndex = 0
    while (cur < overWeak.size && friendIndex<friendArr.size){
        next = cur+1
        while (next<overWeak.size && overWeak[cur]+friendArr[friendIndex]>=overWeak[next]){
            next++
        }
        cur = next
        friendIndex++
    }
    if (cur==overWeak.size)
        return friendIndex
    else return Int.MAX_VALUE
}


