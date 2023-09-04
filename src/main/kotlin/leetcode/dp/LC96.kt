package leetcode.dp

class LC96 {
    fun numTrees(n: Int): Int {
        // 1. 确定dp数组（dp table）以及下标的含义
        val dp = IntArray(n + 1)
        dp[0] = 1
        dp[1] = 1
        //3. dp数组如何初始化

        //4.确定遍历顺序
        for (i in 2 ..n) {
            for (j in 1 ..i) { // 注意这里边界，一开始都 没加==
//                println(" dp[$i] ${dp[i]} += (dp[j - 1] ${dp[j - 1]}  * dp[i - j]) ${dp[i - j]}  j = $j")
                dp[i] += (dp[j - 1] * dp[i - j]) //2.确定递推公式
            }
        }
        return dp[n]
    }
}