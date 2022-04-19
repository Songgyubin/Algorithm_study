import java.lang.Integer.max

private fun main() {

}

private lateinit var pillar: Array<BooleanArray>
private lateinit var bar: Array<BooleanArray>


private fun solution(n: Int, build_frame: Array<IntArray>): Array<IntArray> {
    var answer = arrayOf<IntArray>()
    // 기둥은 바닥 위에 있거나 보의 한쪽 끝 부분에 있거나 다른 기둥위에 있어야 함
    // 보는 한쪽 끝 부분이 기둥 위에 있거나, 양쪽 끝 부분이 다른 보와 동시에 연결되어 있어야 함
    // (가로,세로)
    // 기둥과 보를 삭제하는 능도 있지만, 삭제 후에 규칙을 만족하지 않는다면, 작업 무시
    // build_frame: 설치하거나 삭제하는 작업이 순서대로 담김
    // x,y 교차점 좌표 [가로,세로]
    // a 0: 기둥 1: 보
    // b 0: 삭제 1: 설치
    // 교차점 기준으로 보는 오른쪽, 기둥은 위쪽 방향으로 설치 or 삭제
    // 가로가 3인 2차원배열 [][3]
    // 배열의 원소 [x,y,a]
    // x좌표 기준으로 오름차순 정렬, x좌표가 같을 경우 y좌표 기준으로 오름차순 정렬
    // x,y좌표가 같은 경우 기둥이 앞에 온다.
    pillar = Array(n + 1) { BooleanArray(n + 1) }
    bar = Array(n + 1) { BooleanArray(n + 1) }
    var count = 0

    for (build in build_frame) {
        val (x, y, type, cmd) = build
        if (type == 0) {
            if (cmd == 1) {
                if (checkPillar(x, y)) {
                    pillar[x][y] = true
                    count++
                }
            } else {
                pillar[x][y] = false
                count--
                if (!canDelete(x, y, n)) {
                    pillar[x][y] = true
                    count++
                }
            }
        } else if (type == 1) {
            if (cmd == 1) {
                if (checkBar(x, y, n)) {
                    bar[x][y] = true
                    count++
                }
            } else {
                bar[x][y] = false
                count--
                if (!canDelete(x, y, n)) {
                    bar[x][y] = true
                    count++
                }
            }
        }
    }
    answer = Array(count) { IntArray(3) }
    count = 0
    for (x in 0..n) {
        for (y in 0..n) {
            if (pillar[x][y]) {
                answer[count][0] = x
                answer[count][1] = y
                answer[count][2] = 0
                count++
            }
            if (bar[x][y]) {
                answer[count][0] = x
                answer[count][1] = y
                answer[count][2] = 1
                count++
            }
        }
    }

    return answer
}

private fun canDelete(x: Int, y: Int, n: Int): Boolean {
    for (i in max(x - 1, 0)..x + 1) {
        for (j in y..y + 1) {
            if (pillar[i][j] && !checkPillar(i, j)) return false
            if (bar[i][j] && !checkBar(i, j, n)) return false
        }
    }
    return true
}

private fun checkPillar(x: Int, y: Int): Boolean {
    if (y == 0 || pillar[x][y - 1]) return true
    if ((x > 0 && bar[x - 1][y]) || bar[x][y]) return true

    return false
}

private fun checkBar(x: Int, y: Int, n: Int): Boolean {
    if (pillar[x][y - 1] || (x < n && pillar[x + 1][y - 1])) return true
    if (x > 0 && bar[x - 1][y] && bar[x + 1][y]) return true

    return false
}
