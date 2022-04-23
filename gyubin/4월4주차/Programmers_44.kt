import java.lang.Integer.max

private fun main() {

}


private fun solution(stones: IntArray, k: Int): Int {
    var answer = 0
    // 디딤돌의 숫자는 한 번 밟을 떄마다 1씩 줄어듦
    // 0이 되면 더 이상 밟을 수 없고, 그 다음 디딤돌로 한 번에 여러 칸을 건너 뛸 수 있다.
    // 다음으로 밟을 수 있는 디딤돌이 여러 개인 경우 무조건 가장 가까운 디딤돌로만 건너뛸 수 있다.

    var min = 1
    var max = 200000000
    while (min <= max) {
        val mid = (min + max) / 2
        if (canMoveDidimdol(stones, k, mid)) {
            min = mid + 1
            answer = max(answer, mid)
        } else {
            max = mid - 1
        }
    }
    return answer
}

private fun canMoveDidimdol(stones: IntArray, k: Int, friends: Int): Boolean {
    var skip = 0
    for (stone in stones) {
        if (stone - friends < 0) {
            skip++
        } else {
            skip = 0
        }
        if (skip == k) return false
    }
    return true
}