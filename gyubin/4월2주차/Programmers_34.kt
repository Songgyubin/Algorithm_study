private fun main() {
    println(
        solution(
            arrayOf("muzi", "frodo", "apeach", "neo"),
            arrayOf("muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"),
            2
        ).joinToString("")
    )
    println(
        solution(
            arrayOf("con", "ryan"),
            arrayOf("ryan con", "ryan con", "ryan con", "ryan con"),
            2
        ).joinToString("")
    )

}

private fun solution(id_list: Array<String>, report: Array<String>, k: Int): IntArray {
    var answer = intArrayOf()
    val tmpReport = report.distinct()
    // 각 유저는 한 번에 한 명의 유저를 신고 가능
    // 여러 번 신고 가능하지만 동일 유저에게는 신고 횟수는 1회로 처리

    // k번 이상 신고된 유저는 게시판 이용이 정지되며,
    // 해당 유저를 신고한 모든 유저에게 정지 사실을 메일로 발송
    // 유저가 신고한 모든 내용을 취합하여 마지막에 한꺼번에 게시판 이용 정지를 시키면서
    // 정지 메일 발송합니다.

    // 신고당한애, 신고횟수
    val reportedCount = HashMap<String, Int>()
    //  신고한 애,신고당한 애
    val reportedAndReportPeople = LinkedHashMap<String, ArrayList<String>>()
    // 신고한 애, 신고 성공 횟수
    val mailCount = LinkedHashMap<String, Int>()
    id_list.forEach {
        reportedAndReportPeople[it] = ArrayList()
        mailCount[it] = 0
    }

    tmpReport.forEach {
        val tmp = it.split(" ")
        val reportPeople = tmp[0]
        val reportedPeople = tmp[1]
        reportedCount[reportedPeople] = reportedCount.getOrDefault(reportedPeople, 0) + 1
        val reportedPeopleList = reportedAndReportPeople[reportPeople]!!
        reportedPeopleList.add(reportedPeople)
        reportedAndReportPeople[reportPeople] = reportedPeopleList
    }
    reportedCount.filter { it.value >= k }.keys.forEach { reportedPeople ->
        reportedAndReportPeople.filter { it.value.contains(reportedPeople) }.keys.forEach {
            mailCount[it] = mailCount.getOrDefault(it, 0) + 1
        }
    }
    answer = mailCount.values.toIntArray()

    return answer
}