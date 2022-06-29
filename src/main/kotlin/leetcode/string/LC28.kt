package leetcode.string

class LC28 {
    fun strStr(haystack: String, needle: String): Int {
        var needleIndex = 0
        for (i in haystack.indices) {
            var hayIndex = i
            while (needleIndex < needle.length) {
                if (haystack.getOrNull(hayIndex) == needle[needleIndex]) {
                    if (needleIndex == needle.length - 1) return i
                    hayIndex++
                    needleIndex++
                } else {
                    needleIndex = 0
                    break
                }
            }
        }
        return -1
    }


    fun strStrKmp(haystack: String, needle: String): Int {
        var j = 0
        var nextArray = initNext(needle) // 初始化next数组
        for (i in haystack.indices) {       // 文本串指针i 移动
            while (j > 0 && haystack[i] != needle[j]) {
                j = nextArray[j - 1]    // 模式串 指针 根据next数组的下标回退
            }
            if (haystack[i] == needle[j]) { // 文本串 模式串对应的字符相等
                j++
            }
            if (j == needle.length) {
                return i - j + 1
            }
        }
        return -1
    }

    /**
     * 模式串
     * i指向后缀末尾位置
     * j 指向前缀末尾位置， 也代表 i和i之前的 最长公共前后缀的长度
     */
    fun initNext(needle: String): IntArray {
        var nextArray = IntArray(needle.length)
        var j = 0 // j 前缀0开始初始化
        for (i in 1 until needle.length) { // i后缀末尾 ，从1开始初始化
            while (j > 0 && needle[i] != needle[j]) {
                j = nextArray[j - 1]            // 前一个位置下标 回退
            }
            if (needle[i] == needle[j]) j++     // 找到新的相等字符， 在之前最长公共前后缀长度 +1
            nextArray[i] = j // 更新next下标
        }
        return nextArray
    }

}