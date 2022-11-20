package leetcode.backtrack.combination

import java.lang.StringBuilder

class LC17 {
    val result = ArrayList<String>()
    val pathStr = StringBuilder()
    fun letterCombinations(digits: String): List<String> {
        val arrayList = arrayListOf(
            null,
            null,
            ("abc"),
            ("def"),
            ("ghi"),
            ("jkl"),
            ("mno"),
            ("pqrs"),
            ("tuv"),
            ("wxyz")
        )
        backTrack(arrayList, digits, 0)
        return result
    }

    private fun backTrack(arrayList: ArrayList<String?>, digits: String, index: Int) {
        if (index == digits.length) {
            if (pathStr.isNotEmpty()) result.add(String(pathStr))
            return
        }
        val digit = digits[index] - '0'
        val item = arrayList[digit] ?: return
        for (i in item.indices) {
            pathStr.append(item[i])
            backTrack(arrayList, digits, index + 1)
            pathStr.deleteCharAt(pathStr.length - 1)
        }
    }
}