private var answer = false
private fun main() {
    var key = Array(0) { IntArray(0) }
    var lock = Array(0) { IntArray(0) }
    println(solution(key, lock))
}
private fun solution(key: Array<IntArray>, lock: Array<IntArray>): Boolean {
    val point = key.size - 1

    // 열쇠는 회전과 이동 가능
    // 돌기 부분을 홈 부분에 딱 맞게 채우면 열림
    // 자물쇠 영역에서 열쇠의 돌기 부분과 자물쇠 부분이 일치해야 함
    // 열쇠의 돌기가 자물쇠 돌기와 만나면 안 된다.
    // 자물쇠의 모든 홈이 비어있는 곳이 없어야 자물쇠를 열 수 있다.

    // 열 수 있으면 true
    // 열 수 없으면 false

    // 0은 홈 부분, 1은 돌기 부분

    for (x in 0 until point + lock.size) { //이동 거리는 열쇠와 자물쇠가 처음으로 겹치는 부분 + 자물쇠의 크기이다.
        for (y in 0 until point + lock.size) {
            //key를 회전한다.
            for (r in 0..3) {
                val newLock = Array(lock.size + key.size * 2) {
                    IntArray(
                        lock.size + key.size * 2
                    )
                } //확장한 lock배열 생성
                for (i in lock.indices) {
                    for (j in lock.indices) {
                        newLock[i + point][j + point] = lock[i][j] //확장할 lock배열(arr) 초기화
                    }
                }
                match(newLock, key, r, x, y) //newLock배열에 key배열을 더해준다
                if (isOpen(newLock, point, lock.size)) return true //자물쇠 영역이 모두 유효한 값인지 확인
            }
        }
    }
    return false
}

private fun match(newLock: Array<IntArray>, key: Array<IntArray>, rot: Int, x: Int, y: Int) {
    val len = key.size
    for (i in 0 until len) {
        for (j in 0 until len) {
            when (rot) {
                0 -> {
                    newLock[x + i][y + j] += key[i][j]
                }
                1 -> {
                    newLock[x + i][y + j] += key[j][len - i - 1]
                }
                2 -> {
                    newLock[x + i][y + j] += key[len - i - 1][len - j - 1]
                }
                else -> {
                    newLock[x + i][y + j] += key[len - j - 1][i]
                }
            }
        }
    }
}

private fun isOpen(newLock: Array<IntArray>, point: Int, len: Int): Boolean {
    for (i in 0 until len) {
        for (j in 0 until len) {
            if (newLock[point + i][point + j] != 1) return false
        }
    }
    return true
}
