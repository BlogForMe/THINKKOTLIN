package leetcode.string

class LC344 {
    fun reverseString(s: CharArray): Unit {
        var left = 0
        var right = s.size - 1
        while (left < right) {
            swap(s, left, right)
            left++
            right--
        }
    }

    fun swap(s: CharArray, left: Int, right: Int) {
        val temp = s[left]
        s[left] = s[right]
        s[right] = temp
    }
}