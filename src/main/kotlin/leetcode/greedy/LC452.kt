package leetcode.greedy

import java.util.*

class LC452 {

        //chatgpt
    fun findMinArrowShots(points: Array<IntArray>): Int {
        if (points.isEmpty()) return 0
        points.sortBy { it[1] }
        var arrows = 1
        var end = points[0][1]

        for (i in 1 until points.size) {
            if (points[i][0]>end) {
                arrows++
                end = points[i][1]
            }
        }

        return arrows
    }


    fun findMinArrowShots1(points: Array<IntArray>): Int {
//        Arrays.sort(points){o1,o2 -> o1[0] - o2[0]} 这个回报越界错 [[-2147483646,-2147483645],[2147483646,2147483647]]
        points.sortBy{it[0]}
        var count = 1
        for (i in 1 until points.size) {
            if (points[i][0] > points[i - 1][1]) { // 如果当前气球的左边界 > 公共右边界
                count++
            } else {
                // 没有大于公共右边界
                points[i][1] = points[i][1].coerceAtMost(points[i - 1][1]) // 更新重叠气球最小右边界
            }
        }
//        points.printDimensionalArray()
        return count
    }
}