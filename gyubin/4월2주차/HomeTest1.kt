private fun main() {
    println("answer: ${solution("EEESEEEEEENNNN").joinToString("\n")}")
}

private fun solution(path: String): Array<String> {
    var answer = mutableListOf<String>()
    // 다음 방향 변경 지점까지 거리가 500m 이거나
    // 출발 혹은 방향 변경 직후 다음 방향 변경 지점까지가 500m 이하면 다음 형식
    // x: 안내 메시지 보내는 시간
    //100m당 1만큼 소요
    // y: 다음 방향 변경지점까지 직선거리
    // direction: 진행 방향 기준 바꿔야할 방향 left right
    // E W S N

    val dirArr = sliceDir(path)
    println(dirArr.joinToString("\n"))

    var curDir = 'N'
    var time = 0
    var tmpTime = 0
    var goDir = "left or right"
    var tmpCount = 0
    // count - 5
    for (i in 0 until dirArr.size - 1) {
        val (dir, count) = dirArr[i]
        val (nextDir, nextCount) = dirArr[i + 1]
        tmpCount = count
        if (count > 5) {
            tmpTime = count - 5
            time += tmpTime
            tmpCount = 5
        }
        goDir = changeDir(dir, nextDir)
        answer.add("Time $time: Go straight ${tmpCount * 100}m and turn $goDir")
        time += count
        if (count > 5) {
            time -= count - 5
        }

    }

    return answer.toTypedArray()
}

private fun changeDir(curDir: Char, dir: Char): String {
    var goDir = "left or right"
    when (curDir) {
        'E' -> {
            if (dir == 'N') {
                goDir = "left"
            } else if (dir == 'S') {
                goDir = "right"
            }
        }
        'W' -> {
            if (dir == 'N') {
                goDir = "right"
            } else if (dir == 'S') {
                goDir = "left"
            }
        }
        'S' -> {
            if (dir == 'E') {
                goDir = "left"
            } else if (dir == 'W') {
                goDir = "right"
            }
        }
        'N' -> {
            if (dir == 'E') {
                goDir = "right"
            } else if (dir == 'W') {
                goDir = "left"
            }
        }
    }
    return goDir
}

private fun sliceDir(path: String): ArrayList<Pair<Char, Int>> {
    var dirArr = ArrayList<Pair<Char, Int>>()
    var curDir = path[0]
    var count = 0
    for (dir in path) {
        if (curDir != dir) {
            dirArr.add(Pair(curDir, count))
            count = 0
            curDir = dir
        }
        count++
    }
    dirArr.add(Pair(curDir, count))
    return dirArr
}