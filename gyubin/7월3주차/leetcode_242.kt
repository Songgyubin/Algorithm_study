private fun main() {
}
// Valid Anagram
private fun isAnagram(s: String, t: String): Boolean = s.toCharArray().sorted()==t.toCharArray().sorted()