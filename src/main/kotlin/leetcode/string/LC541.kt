package leetcode.string

class LC541 {
    fun reverseStr(s: String, k: Int): String {
        val charArray = s.toCharArray()
        for (i in s.indices step 2 * k) {
            var left = i  // 每次的left指针设置好
            var right = (i + k - 1)   //接着设置每次的 右指针
            if (right > s.length - 1) { // 如果字符串长度小于 这次的右指针，使用字符串的右边界作为右指针
                right = s.length - 1
            }
            while (left < right) {  //反转
                LC344().swap(charArray, left, right)
                left++
                right--
            }
        }
        return String(charArray)
    }
}