package leetcode.dp

import leetcode.ext.printIntArray

class LC494 {


    fun findTargetSumWays(nums: IntArray, target: Int): Int {

        /**
         *  positive - negative = target
         *  positive + negative = sum
         *
         *  positive  =  (target + sum)/2
         *
         */

        //dp[j] += dp[j - nums[i]]对这句组合数的理解： 1、如果不选第i个数（nums[i]）的话，则方法数为dp[j]； 2、如果选第i个数（nums[i]）的话，则方法数为dp[j - nums[i]]；
        // 所以方法总数为：dp[j] = dp[j] + dp[j - nums[i]]；（感觉这样拆开写比较容易理解） 可以对比其他01背包问题：dp[j] = max(dp[j], dp[j - nums[i]])，这种问题即是从选i与不选i里，选取最大值。

        var sum = 0
        nums.forEach {
            sum += it
        }

        if (Math.abs(target)>sum) return 0 // 如果target 大于 sum是不可能有值的

        if ((target + sum) % 2 != 0) return 0 // positive 一定是正整数 ,这种情况下没有

        val positive = (target + sum) / 2
        val dp = IntArray(positive + 1)
        dp[0] = 1
        for (i in nums.indices) {
            for (j in positive downTo nums[i]) { // j表示背包容量
                println(" i = $i  j = $j   j - nums[i] = ${j - nums[i]}  dp[j - nums[i]]  ${dp[j - nums[i]]} ")
                dp[j] += dp[j - nums[i]]
                println(" dp[j] ${dp[j]}  ")
            }
            println()
            dp.printIntArray()
            println()
            println()
        }
        return dp[positive]
    }

    /**
     * 带注释版本
     */
//    fun findTargetSumWays(nums: IntArray, target: Int): Int {
//        var sum = 0
//        for (i in nums.indices) sum += nums[i]
//        //如果target过大 sum将无法满足
//        if (target < 0 && sum < -target) return 0
//        if ((target + sum) % 2 != 0) return 0
//        var size = (target + sum) / 2
//        if (size < 0) size = -size
//        val dp = IntArray(size + 1)
//        dp[0] = 1
//        for (i in nums.indices) {
//            for (j in size downTo nums[i]) {
//                println(" i = $i  j = $j   j - nums[i] = ${j - nums[i]}  dp[j - nums[i]]  ${dp[j - nums[i]]} ")
//                dp[j] = (dp[j] + dp[j - nums[i]])
//                println(" dp[j] ${dp[j]}  ")
//            }
//            println()
//            dp.printIntArray()
//            println()
//            println()
//        }
//        return dp[size]
//    }
}