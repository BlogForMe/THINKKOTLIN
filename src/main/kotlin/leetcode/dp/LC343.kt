package leetcode.dp

import max


class LC343 {
    fun integerBreak(n: Int): Int {
        if (n == 2) return 1  // 1+1
        val dp = IntArray(n + 1)
        dp[0] = 0
        dp[1] = 0
        dp[2] = 1
        for (i in 3..n) {
            for (j in 1 until i) {
//                println("i $i    j $j ")
                val a = j * (i - j)
                val b = j * dp[i - j]
//                maxNum = max(a, b, i)
                println("j * (i - j)  $j * ($i - $j)  a =$a  dp[i - j] ${dp[i - j]}  b= $b ")
//                maxNum = max(a, b,dp[i])
//                maxNum= max(a,b)
//                val abMax = max(a, b)
//                println("abMax $abMax dp[$i] ${dp[i]} ")
                dp[i] = max(a, b, dp[i]) // dp[i] 初始值是0，所以得出的值还是从a,b中拿到最大值
            }
//            println("dp[$i]     ${dp[i]}")
        }
        return dp[n]
    }
}