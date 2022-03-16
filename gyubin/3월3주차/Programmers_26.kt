import java.util.*

private fun main() {
    println(
        solution(
            arrayOf("classic", "pop", "classic", "classic", "pop"),
            intArrayOf(500, 600, 150, 800, 2500)
        ).joinToString(" ")
    )

}

private fun solution(genres: Array<String>, plays: IntArray): IntArray {
    var answer = mutableListOf<Int>()
    // 가장 많이 재생된 노래를 두 개씩 모아서 베스트 앨범을 출시
    // 노래는 고유 번호로 구분
    // 속한 노래가 많이 재생된 장르를 먼저 수록
    // 장르 내에서 많이 재생된 노래를 먼저 수록
    // 장르 내에서 재생횟수가 같은 노래 중에서 고유 번호가 낮은 노래를 먼저 수록
    // 고유번호: i

    val genresHash = HashMap<String, Int>()
    val genreCountHash = HashMap<String, Int>()
    val genreMaximumHash = HashMap<String, Int>()
    for (i in genres.indices) {
        genresHash[genres[i]] = genresHash.getOrDefault(genres[i], 0) + plays[i]
        genreCountHash["${genres[i]} $i"] = genreCountHash.getOrDefault("${genres[i]} $i", 0) + plays[i]
    }
    val genrePriorityQueue = PriorityQueue<GenrePlay>()
    genresHash.forEach {
        genrePriorityQueue.add(GenrePlay(it.key, it.value))
    }
    val albumPriorityQueue = PriorityQueue<Album>()
    while (genrePriorityQueue.isNotEmpty()) {
        val queue = genrePriorityQueue.poll()
        val genre = queue.genre

        genreCountHash.forEach {
            if (it.key.contains(genre)) {
                albumPriorityQueue.add(Album(it.key.split(" ")[0], it.value, it.key.split(" ")[1].toInt()))
            }
        }
        while (albumPriorityQueue.isNotEmpty()) {
            val tmpQueue = albumPriorityQueue.poll()
            genreMaximumHash[tmpQueue.genre] = genreMaximumHash.getOrDefault(tmpQueue.genre, 0) + 1
            if (genreMaximumHash[genre]!! < 3) {
                answer.add(tmpQueue.index)
            }
        }
    }

    return answer.toIntArray()
}

data class GenrePlay(val genre: String, val play: Int) : Comparable<GenrePlay> {
    override fun compareTo(other: GenrePlay): Int = other.play - this.play
}

data class Album(val genre: String, val play: Int, val index: Int) : Comparable<Album> {
    override fun compareTo(other: Album): Int {
        if (other.play == this.play) return this.index - other.index
        else return other.play - this.play
    }

}
