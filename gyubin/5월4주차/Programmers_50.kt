private fun main() {
    println(
        solution(
            arrayOf("john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"),
            arrayOf("-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"),
            arrayOf("young", "john", "tod", "emily", "mary"),
            intArrayOf(12, 4, 2, 5, 10)
        ).joinToString("\n")
    )
    val arr = ArrayList<Int>()
    arr.add(0)
    arr.add(1)
    arr.add(2)
    arr.add(3)
    arr.add(4)
    arr.add(5)
    arr.add(6)
    arr.removeAt(1)
    arr.add(1, 101)
//    arr.forEach { println(it) }
}

private fun solution(
    enroll: Array<String>,
    referral: Array<String>,
    seller: Array<String>,
    amount: IntArray
): IntArray {
    val answer = IntArray(enroll.size)
    // 자신의 이익금에서 /10을 배분하고 나머지를 자신이 가진다
    // 배분 금액 = 이익금 / 10
    // 가질 금액 = 이익금 - 배분 금액
    // amount 판매개수 , index는 seller와 같다.


    // 자식이 여러 개인 부모가 있기 때문에
    // 자식을 키로 잡고 각각 계산하기 <자식, 부모>
    val parentMap = HashMap<String, String>()
    // seller가 중복되어 나올 수 있으므로 index를 저장하여 이익금 계산할 때 위치 찾기
    val indexMap = HashMap<String, Int>()



    enroll.forEachIndexed { index, child ->
        val parent = referral[index]
        parentMap[child] = parent
        indexMap[child] = index
    }

    for (i in seller.indices) {
        var tmpSeller = seller[i]
        var profit = amount[i] * 100
        while (true) {
            if (tmpSeller == "-") break
            if (profit < 1) break
            val dividend = profit / 10
            val myProfit = profit - dividend
            // 자신의 금액 추가
            answer[indexMap[tmpSeller]!!] += myProfit

            // 현재의 부모가 받은 배당금의 10%를 또 그 위의 부모에게 전달
            tmpSeller = parentMap[tmpSeller]!!
            profit /= 10

        }
    }

    return answer
}