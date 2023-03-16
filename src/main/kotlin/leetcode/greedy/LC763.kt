package leetcode.greedy

class LC763 {
    fun partitionLabels(s: String): List<Int> {
        val result = arrayListOf<Int>()
        val hash = IntArray(26)
        for (i in s.indices) {
            hash[s[i] - 'a'] = i
        }

        var left = 0
        var right = 0
        for (i in s.indices) {
            right = hash[s[i] - 'a'].coerceAtLeast(right) // 要找到当前hash值的最大值
            if (right == i) {   //如果 hash值的最大值 和座标相等，就用到了分割点
                result.add(right + 1 - left)
                left = i + 1
            }
        }
//        hash.printIntArray()
        return result
    }
}