package leetcode.greedy

import leetcode.ext.printIntArray

class LC135 {
    fun candy(ratings: IntArray): Int {
        val answer = IntArray(ratings.size)
        answer[0] = 1

//       1. 左边孩子粉丝的情况 < 右边孩子分数  ，此时需要从左往右
        for (i in 1 until ratings.size) {
            if (ratings[i] > ratings[i - 1]) {
                answer[i] = answer[i - 1] + 1
            } else {
                answer[i] = 1
            }
        }
        println()
        answer.printIntArray()
        // 2. 左边孩子粉丝 > 右边孩子分数的情况, 此时需要从右向左
        for (i in ratings.size - 1 downTo 1) {
            if (ratings[i - 1] > ratings[i]) {
                answer[i - 1] = answer[i - 1].coerceAtLeast(answer[i] + 1) // 3. 取大的值
            }
        }

        answer.printIntArray()

        var sum = 0
        for (i in answer) {
            sum += i
        }
        return sum
    }
}