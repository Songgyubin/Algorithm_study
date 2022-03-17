private fun main() {

//    solution(arrayOf(arrayOf("ICN", "JFK"), arrayOf("HND", "IAD"), arrayOf("JFK", "HND")))
    println(
        (solution(
            arrayOf(
                arrayOf("ICN", "SFO"),
                arrayOf("ICN", "ATL"),
                arrayOf("SFO", "ATL"),
                arrayOf("ATL", "ICN"),
                arrayOf("ATL", "SFO")
            )
        ).joinToString(" "))
    )
}

private var answerRoute = ArrayList<String>()
private lateinit var vis: BooleanArray
private fun solution(tickets: Array<Array<String>>): Array<String> {
    var answer = arrayOf<String>()
    // ICN
    // 모든 공항은 알파벳 대글자
    // 주어진 항공권은 모두 사용해야 함
    // 만일 가능한 경로가 2개 이상일 경우 알파벳 순서가 앞서는 경로  return
    vis = BooleanArray(tickets.size)
    dfs("ICN", "ICN", tickets, 0)
    return answerRoute.sorted()[0].split(" ").toTypedArray()
}

private fun dfs(start: String, route: String, tickets: Array<Array<String>>, count: Int) {
    if (count == tickets.size) {
        answerRoute.add(route)
        return
    }
    for (i in 0 until tickets.size) {
        if (start == tickets[i][0] && !vis[i]) {
            vis[i] = true
            dfs(tickets[i][1], "$route ${tickets[i][1]}", tickets, count + 1)
            vis[i] = false
        }
    }
}