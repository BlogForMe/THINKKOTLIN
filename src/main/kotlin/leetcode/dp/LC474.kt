package leetcode.dp

class LC474 {
    fun findMaxForm(strs: Array<String>, m: Int, n: Int): Int {
        val dp = Array(m + 1) { IntArray(n + 1) }

        strs.forEachIndexed { index, str ->
            var oneNum = 0  // 一开始放，外面，要在里面
            var zeroNum = 0
            str.forEach {
                if ('1' == it) {
                    oneNum++
                } else {
                    zeroNum++
                }
            }
            for (i in m downTo zeroNum) { //
                for (j in n downTo oneNum) {
//                    dp[i][j] = Math.max(dp[i][j], dp[m - i][n - j] + 1) // 错的写法
                    dp[i][j] = Math.max(dp[i][j], dp[i-zeroNum][j - oneNum] + 1)
                }
            }
        }
        return dp[m][n]
    }
}