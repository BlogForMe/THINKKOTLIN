package leetcode.string

class OFFER58 {
    fun reverseLeftWords(s: String, n: Int): String {
        val sb = StringBuilder(s)
        for (i in 0 until n) {
            sb.append(s[i])
            sb.deleteCharAt(0)
        }
        return sb.toString()
    }
}