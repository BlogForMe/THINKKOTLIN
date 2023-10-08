package leetcode.dp

import leetcode.ext.printIntArray

class LC1049 {
    fun lastStoneWeightII(stones: IntArray): Int {
        var sum = 0
        stones.forEach {
            sum += it // total sum
        }
        val target = sum / 2

        val dp = IntArray(target + 1)
        for (i in 0 until stones.size) {
            for (j in target downTo stones[i]) {
//                println(" j = $j   j - nums[i] = ${j - stones[i]}      dp[j - nums[i]]  ${dp[j - stones[i]]} ")
                dp[j] = Math.max(dp[j - stones[i]] + stones[i], dp[j])
//                print(" dp[j] ${dp[j]}  ")
            }
//            dp.printIntArray()
//            println()
        }
        return sum - dp[target]*2 // 这是target,而不是物品的size
    }
}