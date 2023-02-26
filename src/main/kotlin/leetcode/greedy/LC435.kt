package leetcode.greedy

import printDimensionalArray
import java.util.*

class LC435 {
    fun eraseOverlapIntervals(intervals: Array<IntArray>): Int {
        var count = 0
        Arrays.sort(intervals) { a, b -> a[0] - b[0] }
        intervals.printDimensionalArray()

        return count
    }
}