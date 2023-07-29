package leetcode.dp

class LC63 {
    fun uniquePathsWithObstacles(obstacleGrid: Array<IntArray>): Int {
        val m = obstacleGrid.size // 表示有多少个数组
        val n = obstacleGrid[0].size // 其中一个数组的长度

        if (obstacleGrid[0][0] == 1 || obstacleGrid[m-1][n-1] == 1) return 0 // if there are obstacle in these two points, will no path.

        val dp = Array(m) { IntArray(n) }
        for (i in 0 until m) { // 里面再加个条件不好加
            if (obstacleGrid[i][0] == 1) break      // when init dats, hit path , following init will 0
            dp[i][0] = 1 // 前面[i][0] i表述多少个数组
        }
        for (j in 0 until n) {
            if (obstacleGrid[0][j] == 1) break
            dp[0][j] = 1 // [0][j] 后面表述一个数组的长度
        }
        for (i in 1 until m) {
            for (j in 1 until n) {
                if (obstacleGrid[i][j] != 1) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
                }
            }
        }
        return dp[m - 1][n - 1]
    }
}