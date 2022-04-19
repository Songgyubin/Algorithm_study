private lateinit var arr: Array<IntArray>

private fun main() {
    // 1. 한 나라라도 승 무 패의 합이 5가 아닌 경우
    // 2. 무승부의 count가 홀수인경우
    // 3. 15 초과인 경우
    for (t in 0 until 4) {
        //0: 승 1: 무 2: 패
        arr = Array(6) { IntArray(3) }
        var total = 0
        val tmp = readln().split(" ").map { it.toInt() }
        for (j in 0..15 step 3) {
            arr[j / 3] = tmp.subList(j, j + 3).toIntArray()
            total += arr[j / 3].sum()
        }
        val matches = Array(15) { IntArray(2) }
        var index = 0
        for (i in 0 until 5) {
            for (j in i + 1 until 6) {
                matches[index][0] = i
                matches[index++][1] = j
            }
        }
        if (total == 30 && dfs(arr, matches, 0)) {
            print("1 ")
        } else {
            print("0 ")
        }
    }
}

private fun dfs(arr: Array<IntArray>, matches: Array<IntArray>, round: Int): Boolean {
    if (round == 15) return true
    val (group1, group2) = matches[round]

    // group1 승
    // group2 패
    if (arr[group1][0] > 0 && arr[group2][2] > 0) {
        arr[group1][0]--
        arr[group2][2]--
        if (dfs(arr, matches, round + 1)) return true
        arr[group1][0]++
        arr[group2][2]++
    }
    // group1 무
    // group2 무
    if (arr[group1][1] > 0 && arr[group2][1] > 0) {
        arr[group1][1]--
        arr[group2][1]--
        if (dfs(arr, matches, round + 1)) return true
        arr[group1][1]++
        arr[group2][1]++
    }
    // group1 승
    // group2 패
    if (arr[group1][2] > 0 && arr[group2][0] > 0) {
        arr[group1][2]--
        arr[group2][0]--
        if (dfs(arr, matches, round + 1)) return true
        arr[group1][2]++
        arr[group2][0]++
    }
    return false
}
