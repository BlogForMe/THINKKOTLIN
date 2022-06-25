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
}