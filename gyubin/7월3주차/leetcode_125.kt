private fun main() {
    println(isPalindrome("0P"))
}
// Valid Palindrome
private fun isPalindrome(s: String): Boolean {
    val ss = s.lowercase().filter { it.isLowerCase()||it.isDigit()}
    var end = ss.length
    for (i in 0 until ss.length) {
        if (ss[i]!=ss[--end]) return false
    }
    return true
}