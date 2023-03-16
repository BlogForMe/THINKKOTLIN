package leetcode.greedy

import printDimensionalArray
import java.util.*

class LC435 {

    // 左边数组排序
    fun eraseOverlapIntervals1(intervals: Array<IntArray>): Int {
        if (intervals.isEmpty()) return 0
        var count = 0
        Arrays.sort(intervals) { a, b -> a[0] - b[0] } // 按照左边数组进行排序
        var end = intervals[0][1]
        for (i in 1 until intervals.size) {
            if (intervals[i][0] < end) {    //重合的情况
                count++
                end = end.coerceAtMost(intervals[i][1]) // 确定最小重合的 右边界, 这里一开始弄错了
            } else {
                end = intervals[i][1]
            }
        }
//        intervals.printDimensionalArray()
        return count
    }

    // 按照右边的值排序
    fun eraseOverlapIntervals(intervals: Array<IntArray>): Int {
        if (intervals.isEmpty()) return 0
        var count = 1 //非交叉区间个数
        Arrays.sort(intervals) { a, b -> a[1] - b[1] } // 按照左边数组进行排序
        var end = intervals[0][1]
        for (i in 1 until intervals.size) {
            if (intervals[i][0] >= end) {
                count ++
                end = intervals[i][1]
            }
//            else{
//                end = intervals[i][1].coerceAtMost(end) // 这个不需要
//            }
        }
//        intervals.printDimensionalArray()
        return intervals.size - count
    }
}