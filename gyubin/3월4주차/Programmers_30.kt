private fun main() {
//    println("00:01" in "00:00".."00:02")
//    println(calcAdvTime("01:50:49", "00:20:11"))
    println(
        solution(
            "02:03:55",
            "00:14:15",
            arrayOf(
                "01:20:15-01:45:14",
                "00:40:31-01:00:00",
                "00:25:50-00:48:29",
                "01:30:59-01:53:29",
                "01:37:44-02:02:30"
            )
        )
    )
}

private fun solution(play_time: String, adv_time: String, logs: Array<String>): String {
    var answer: String = ""
    // 광고를 넣었을 때 동영상 길이보다 길다면 ? 그 전으로
    // 시작 시간을 기준으로 잡고 광고 끝난 시간까지 그 사이에 있는 것들의 개수를 구할까?
    // 그렇게 했을 때 영상 시간이 괜찮으면 sort해서 앞에 있는 것으로 ㄱㄱ
    // 안 되면 되는 애를 넣자 (priorityqueue)
    val advArr = IntArray(timeToInt("100:00:00"))
    val playLen = timeToInt(play_time)
    val advLen = timeToInt(adv_time)

    println(advArr.size)
    logs.forEach {
        val (start, end) = it.split("-")
        for (i in timeToInt(start) until timeToInt(end)) advArr[i]++
    }
    var maxIndex = 0
    var maxSum = 0L
    var sum = 0L
    for (i in 0 until advLen) {
        sum += advArr[i]
    }
    maxSum = sum
    for (i in advLen until playLen) {
        sum += advArr[i] - advArr[i - advLen]
        if (sum > maxSum) {
            maxSum = sum
            maxIndex = i - advLen + 1
        }
    }
    return timeToString(maxIndex)
}

private fun timeToString(time: Int): String {
    var result = ""
    var tmpTime = time
    val hour = tmpTime / 3600
    tmpTime %= 3600
    result += if (hour < 10) "0$hour:" else "$hour:"

    val minute = tmpTime / 60
    tmpTime %= 60
    result += if (minute < 10) "0$minute:" else "$minute:"

    if (tmpTime < 10) result += "0$tmpTime" else result += tmpTime

    return result
}

private fun timeToInt(time: String): Int {
    val times = time.split(":").map { it.toInt() }
    var sec = 3600
    var resultTime = 0
    times.forEach {
        val num = it
        resultTime += num * sec
        sec /= 60
    }
    return resultTime
}