private lateinit var rootNode: TrieNode

private fun main() {
    // Map의 키 값에는 문자를 이루는 각각의 단어들이 들어가고, 키와 매핑되는 값에는 자식 노드 클래스가 저장
    rootNode = TrieNode()

}

private fun insert(word: String) {
    var trieNode = rootNode
    for (i in word.indices) {
        trieNode = trieNode.childNode.computeIfAbsent(word[i]) { TrieNode() }
    }
    trieNode.isLastChar = true

}

private fun search(word: String): Boolean {
    var trieNode = rootNode
    for (i in word.indices) {
        val char = word[i]
        val node = trieNode.childNode[char] ?: return false
        trieNode = node
    }
    return trieNode.isLastChar
}

private class Trie(var rootNode: TrieNode = TrieNode())

/*
   childNode: 자식 노드맵
   isLastChar: 마지막 글자인지 여부
 */
private data class TrieNode(var childNode: HashMap<Char, TrieNode> = HashMap(), var isLastChar: Boolean = false)