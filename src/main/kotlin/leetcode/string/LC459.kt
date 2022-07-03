package leetcode.string

class LC459 {
    fun repeatedSubstringPattern(s: String): Boolean {
        val nxtArrr = initNext(s)
        val len = s.length
        if (nxtArrr[len - 1] != 0 && len % (len - nxtArrr[len - 1]) == 0) { //这两句 是根据随想录的公式抄的
            return true
        }
        return false
    }

    private fun initNext(s: String): IntArray {
        var j = 0
        val nxt = IntArray(s.length)
        nxt[0] = 0
        for (i in 1 until s.length) {
            while (j > 0 && s[i] != s[j]) {
                j = nxt[j - 1]
            }
            if (s[i] == s[j]) j++
            nxt[i] = j
        }
        return nxt
    }
}