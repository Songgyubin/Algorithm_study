import java.util.LinkedList
import kotlin.math.min

private fun main() {

    println(
        solution(
            arrayOf(intArrayOf(1, 0, 0, 3), intArrayOf(2, 0, 0, 0), intArrayOf(0, 0, 0, 2), intArrayOf(3, 0, 1, 0)),
            1,
            0
        )
    )
}

private val goX = intArrayOf(-1, 1, 0, 0) // 상 하 좌 우
private val goY = intArrayOf(0, 0, -1, 1)
private val INF = 987654321
private lateinit var vis: Array<BooleanArray>
private lateinit var cardBoard: Array<IntArray>
private fun solution(board: Array<IntArray>, r: Int, c: Int): Int {

    // 4x4
    // 8가지 캐릭터 그림이 그려진 카드 2장씩 무작위 배치
    // 같은 그림의 카드가 앞면이면 사라진다
    // 같은 그림이 아니라면 원 상태로 뒷면
    // 모든 카드 사라지면 게임 종료
    // 방향키만 한 번 누르면 1칸 이동
    // ctrl과 방향키면 누른 키 방향에 있는 가장 가까운 카드로 한 번에 이동
    // 가까운 카드가 없다면 가장 마지막 칸으로 이동 -> 마지막 칸으로 가는 도중 if(카드o) break
    // 뒤집기 하려면 enter
    // 앞면이 보이는 카드가 1장뿐이면, 두번째 카드 뒤집기 전가지 앞면 유지
    // 남은 카드를 모두 제거하는데 필요한 키 조작횟수의 최솟값
    // 방향키와 ctrl 이나 enter 다 1회로 친다.

    cardBoard = board
    return permutation(Card(r, c, 0))
}


private fun permutation(card: Card): Int {
    var result = INF
    for (num in 1..6) {
        val cardArr = ArrayList<Card>()
        for (i in 0 until 4) {
            for (j in 0 until 4) {
                if (cardBoard[i][j] == num) {
                    cardArr.add(Card(i, j, 0))
                }
            }
        }
        if (cardArr.isEmpty()) continue
        val first = bfs(card, cardArr[0]) + bfs(cardArr[0], cardArr[1]) + 2
        val second = bfs(card, cardArr[1]) + bfs(cardArr[1], cardArr[0]) + 2

        for (i in 0 until 2) {
            cardBoard[cardArr[i].x][cardArr[i].y] = 0
        }
        result = min(result, min(first + permutation(cardArr[1]),second + permutation(cardArr[0])) )
        for (i in 0 until 2) {
            cardBoard[cardArr[i].x][cardArr[i].y] = num
        }
    }
    if (result == INF) return 0
    return result
}

private fun bfs(startCard: Card, endCard: Card): Int {
    vis = Array(4) { BooleanArray(4) }
    val queue = LinkedList<Card>()
    queue.add(startCard)
    while (queue.isNotEmpty()) {
        val cur = queue.poll()
        if (cur.x == endCard.x && cur.y == endCard.y) return cur.move
        for (i in 0 until 4) {
            var (nx, ny) = intArrayOf(cur.x + goX[i], cur.y + goY[i])
            if (nx !in 0 until 4 || ny !in 0 until 4) continue
            if (!vis[nx][ny]) {
                vis[nx][ny] = true
                queue.add(Card(nx, ny, cur.move + 1))
            }
            // ctrl 로 이동할 때 최대로 2번 더 이동할 수 있기 때문에
            for (j in 0 until 2) {
                if (cardBoard[nx][ny] != 0) break
                if (nx + goX[i] !in 0 until 4 || ny + goY[i] !in 0 until 4) break
                nx += goX[i]
                ny += goY[i]
            }
            if (!vis[nx][ny]) {
                vis[nx][ny] = true
                queue.add(Card(nx, ny, cur.move + 1))
            }
        }
    }
    return INF
}

data class Card(val x: Int, val y: Int, val move: Int)
