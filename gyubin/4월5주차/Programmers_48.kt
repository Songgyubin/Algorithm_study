import java.util.*

private var vis = Array(5) { BooleanArray(5) }
private lateinit var arr: Array<IntArray>
private val goX = intArrayOf(0, 0, 1, -1)
private val goY = intArrayOf(1, -1, 0, 0)

private fun main() {
    solution(
        arrayOf(
            arrayOf("POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"), arrayOf("POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"),
            arrayOf("PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"), arrayOf("OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"),
            arrayOf("PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP")
        )
    )
}

private fun solution(places: Array<Array<String>>): IntArray {
    var answer = mutableListOf<Int>()
    // 대기실 5개, 각 대기실 5x5
    // 맨해튼거리 2이하로 앉으면 안 된다
    // 파티션으로 막혀있는 경우는 가능
    // 한 명이라도 지키지 않고 있으면 0 return
    // 맨해튼 거리 |r1-r2| + |c1-c2|
    for (i in places.indices) {
        answer.add(bfs(places[i].map { it.toCharArray() }.toTypedArray()))
    }

    return answer.toIntArray()
}

private fun bfs(tmpPlaces: Array<CharArray>): Int {
    for (i in 0 until 5) {
        for (j in 0 until 5) {
            val queue: Queue<Pair<Int, Int>> = LinkedList()
            if (tmpPlaces[i][j] != 'P') continue
//            println("================================")
            queue.add(Pair(i, j))
            arr = Array(5) { IntArray(5) { 0 } }
            vis = Array(5) { BooleanArray(5) }


            while (queue.isNotEmpty()) {
                val place = queue.poll()
                vis[place.first][place.second] = true
                for (k in 0 until 4) {
                    val x = place.first + goX[k]
                    val y = place.second + goY[k]
                    if ((x in 0 until 5) && (y in 0 until 5) && !vis[x][y]) {
                        if (tmpPlaces[x][y] == 'X') continue
                        arr[x][y] = arr[place.first][place.second] + 1
                        vis[x][y] = true

//                        println("first: ${place.first} second: ${place.second}")
//                        println("arr[first][second]: ${arr[place.first][place.second]}")
//                        println("x:$x y:$y")
//                        println("arr[x][y]: ${arr[x][y]}")

                        if (arr[x][y] <= 2 && tmpPlaces[x][y] == 'P') {
//                            println("x: $x y:$y")
                            return 0
                        }
                        queue.add(Pair(x, y))
                    }
                }

            }

        }
    }
    return 1
}