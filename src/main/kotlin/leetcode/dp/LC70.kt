package leetcode.dp

class LC70 {

    /**
     * 递归解法 ， 会超时
     */
    fun climbStairs(n: Int): Int {
        if (n == 0) return 1 // 需要返回1，2 = 1 +1,否则2就不正确了
        if (n == 1) return 1
        val dp = IntArray(n + 1)
        dp[0] = 1
        dp[1] = 1
        return climbStairs(n - 1) + climbStairs(n - 2)
    }


    fun climbStairs1(n: Int): Int {
        if (n == 0) return 1
        if (n == 1) return 1
        val dp = IntArray(n + 1)
        dp[0] = 1
        dp[1] = 1
        for (i in 2..n) {
            dp[i] = dp[i - 1] + dp[i - 2]
        }
        return dp[n]
    }
}