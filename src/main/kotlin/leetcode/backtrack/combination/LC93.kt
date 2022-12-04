package leetcode.backtrack.combination

class LC93 {
    val result = ArrayList<String>()
    val path = ArrayList<String>()
    fun restoreIpAddresses(s: String): List<String> {
        backTrack(s, 0, 0)
        return result
    }

    private fun backTrack(s: String, startIndex: Int, layer: Int) {
        if (layer == 3) {   // 第三个分割线
            val substring = s.substring(startIndex, s.length) // 这里的方式就解决了，分割所有子串的问题，最后一次分割，直接到字符串的终点。
            if (isValid(substring)) {
                path.add(substring)
                result.add(path.toList().joinToString(separator = "."))
                path.removeAt(path.size-1) // 最后的字符串回溯
            }
            return
        }
        for (i in startIndex until s.length) {
            val substring = s.substring(startIndex, i + 1)
            if (isValid(substring)) {
                path.add(substring)
                backTrack(s, i + 1, layer + 1) // 注意我这里经常传错用 startIndex,这个只是第一个字母，造成只是一个个字母分割
                path.removeAt(path.size-1)
            }
        }
    }

    // 判断字符串s在左闭又闭区间[start, end]所组成的数字是否合法
    private fun isValid(s: String): Boolean {
        val start = 0
        val end = s.length - 1
        if (start > end) {
            return false;
        }
        if (s[start] == '0' && start != end) { // 0开头的数字不合法
            return false;
        }
        var num = 0;
        for (i in start..end) {
            if (s[i] > '9' || s[i] < '0') { // 遇到非数字字符不合法
                return false;
            }
            num = num * 10 + (s[i] - '0');
            if (num > 255) { // 如果大于255了不合法
                return false;
            }
        }
        return true;
    }
}