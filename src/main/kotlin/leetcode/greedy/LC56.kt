package leetcode.greedy

import java.util.*

class LC56 {
    fun merge1(intervals: Array<IntArray>): Array<IntArray> {
        Arrays.sort(intervals) { a, b -> a[0] - b[0] }
        var left = intervals[0][0]
        var right = intervals[0][1]
        val arrayOf = arrayListOf<IntArray>()
        for (i in 1 until intervals.size) {
            if (intervals[i][0] <= right) {
                right = right.coerceAtLeast(intervals[i][1]) // 如果有重合， 确定右边界 位置
            } else {
                arrayOf.add(intArrayOf(left, right)) //如果没有重合，添加进数组
                left = intervals[i][0]
                right = intervals[i][1]
            }
        }
        arrayOf.add(intArrayOf(left, right)) // 最后一个位置 添加进来
        return arrayOf.toTypedArray()
    }

    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        Arrays.sort(intervals) { a, b -> a[0] - b[0] }
        val result = arrayListOf<IntArray>()
        result.add(intervals[0])    // 第一个数组加入结果集
        for (i in 1 until intervals.size) {
            if (intervals[i][0] <= result[result.lastIndex][1]) { //如果新的数组的左边界 < 结果数组的右边界，说明有重合，更新结果数组的右边界。,注意：第一次漏了==条件
                result[result.lastIndex][1] = result[result.lastIndex][1].coerceAtLeast(intervals[i][1]) // 和解题思路1一样，一开始漏了比较右边界值大小
            } else {
                result.add(intervals[i])    //如果新的数组的左边界 > 结果数组的右边界,没有重合，新数组直接添加到结果数组集中。
            }
        }
        return result.toTypedArray()
    }
}