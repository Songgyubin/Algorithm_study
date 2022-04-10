private fun main() {
    /*println(
        solution(
            "this is {template} {template} is {state}",
            arrayOf(arrayOf("template", "string"), arrayOf("state", "changed"))
        )
    )*/
    /*println(
        solution(
            "this is {template} {template} is {state}",
            arrayOf(arrayOf("template", "string"), arrayOf("state", "{template}"))
        )
    )*/
    /*println(
        solution(
            "this is {template} {template} is {state}",
            arrayOf(arrayOf("template", "{state}"), arrayOf("state", "{template}"))
        )
    )*/

    println(
        solution(
            "this is {template} {template} is {state}",
            arrayOf(arrayOf("template", "{state}"), arrayOf("state", "{templates}"))
        )
    )
    /*
    println(
        solution(
            "this is {template} {template} is {state}",
            arrayOf(arrayOf("template", "string"), arrayOf("state", "changed"))
        )
    )*/
}

private fun solution(tstring: String, variables: Array<Array<String>>): String {
    var answer = ""
    // 무한히 반복되는 것 제거
    // - value가 변수형태인것이 저 배열의 크기와 같을 때
    // - 반복될 때도 생각해보자 나중에
    var count = 0
    var varHash = HashMap<String, String>()

    for (i in 0 until variables.size) {
        val (key, value) = variables[i]
        if (value.contains("{") && value.contains("}")) count++
        varHash[key] = value
    }
//    if (count == variables.size) return tstring

    val tStringArr = tstring.split(" ").toTypedArray()
    while (true) {
        if (!isContinue(varHash, tStringArr)) {
            break
        }
        println("?")
        for (i in tStringArr.indices) {
            val str = tStringArr[i]
            if (!isVar(str)) continue
            var tmpStr = str.substring(1, str.lastIndex)
            tStringArr[i] = varHash.getOrDefault(tmpStr, str)
        }
    }

    return tStringArr.joinToString(" ")
}

private fun isVar(string: String): Boolean {
    return string.contains("{") && string.contains("}")
}

private fun isContinue(varHash: HashMap<String, String>, arr: Array<String>): Boolean {
    arr.forEach {
        var tmp = it
        if (isVar(tmp)) tmp = it.substring(1, it.lastIndex)
        if (varHash.keys.contains(tmp)) return true
    }
    return false
}