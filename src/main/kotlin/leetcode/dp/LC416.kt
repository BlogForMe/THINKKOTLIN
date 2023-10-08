package leetcode.dp

import leetcode.ext.printIntArray

class LC416 {
    fun canPartition(nums: IntArray): Boolean {
        var sum = 0
        nums.forEach {
            sum += it
        }
        if (sum % 2 != 0) {
            return false  // will not fill target exactly
        }
        val target = sum / 2
        val dp = IntArray(target + 1)
        println("target $target")
        for (i in 0 until nums.size) {
            println()
            println("   i $i    ")
            println()
            for (j in target downTo nums[i]) {
                println(" j = $j   j - nums[i] = ${j - nums[i]}      dp[j - nums[i]]  ${dp[j - nums[i]]} ")
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]) // 一开始 dp[j] 写成了dp[target]排查了很久
                print("  dp[j] ${dp[j]}  ")
            }
            dp.printIntArray()
            println()
        }
        if (dp[target] == target) {
            return true
        }
        return false
    }
}