private fun main() {
    println(
        solution(
            arrayOf(
                intArrayOf(5, 5, 5, 5, 5),
                intArrayOf(5, 5, 5, 5, 5),
                intArrayOf(5, 5, 5, 5, 5),
                intArrayOf(5, 5, 5, 5, 5)
            ),
            arrayOf(
                intArrayOf(1, 0, 0, 3, 4, 4),
                intArrayOf(1, 2, 0, 2, 3, 2),
                intArrayOf(2, 1, 0, 3, 1, 2),
                intArrayOf(1, 0, 1, 3, 3, 1)
            )
        )
    )
}

private lateinit var arr: Array<IntArray>
private var n = 0
private var m = 0
private fun solution(board: Array<IntArray>, skill: Array<IntArray>): Int {
    var answer: Int = 0
    n = board.size
    m = board[0].size
    // n x m
    // 내구도를 가진 건물이 칸마다 하나씩 있다.
    // 공격받으면 내구도가 감소하고 0이하가 되면 파괴된다.
    // 회복 스킬을 사용하여 내구도 높이기 가능
    // 파괴되었다가 복구 가능
    // 0이하가 되어서 파괴되어도 내구도는 계속해서 내려감
    // skill: type , r1,c1 , r2,c2, degree
    // type
    // 1: 공격
    // 2: 회복
    // 파괴되지 않은 건물의 개수 return
    arr = Array(n+1) { IntArray(m+1) }



    for (i in 0 until skill.size) {
        var (type, r1, c1, r2, c2, degree) = skill[i]
        if (type == 1) degree *= -1

        arr[r1][c1] += degree
        arr[r1][c2 + 1] += (degree * -1)
        arr[r2 + 1][c1] += (degree * -1)
        arr[r2 + 1][c2 + 1] += degree
    }
    calc()
    for (i in 0 until n){
        for (j in 0 until m){
            if (board[i][j]+arr[i][j]>0) answer++
        }
    }

    return answer
}

private fun calc() {
    for (i in 1 until n) {
        for (j in 0 until m){
            arr[i][j] += arr[i-1][j]
        }
    }
    for (j in 1 until m){
        for (i in 0 until n){
            arr[i][j] += arr[i][j-1]
        }
    }
}



private operator fun IntArray.component6(): Int {
    return get(5)
}
