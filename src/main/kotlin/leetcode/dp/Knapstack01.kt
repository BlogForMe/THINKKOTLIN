package leetcode.dp

class Knapstack01 {

    fun knap01(): Int {

        val weightArr = arrayOf(1, 3, 4)
        val valueArr = arrayOf(15, 20, 30)

        val n = 5 // the number of goods
        val w = 8// the max of bag weight
        val dp = Array(n + 1) { IntArray(w + 1) } // 0 is nothing , so need one more

        //即dp[i][j] 表示从下标为[0-i]的物品里任意取，放进容量为j的背包，价值总和最大是多少。
        //初始化

        //j==0 , 背包容量为0，放物品
        for (i in 1 until n) { //number
            dp[i][0] = 0
        }

        // i==0 nothing to put in bag
        for (j in 1 until w) { //weights
            dp[0][j] = 0
        }

        for (i in 0 until n) { //number
            // i==0 , nothing to put in bag
            for (j in 0 until w) { //weights
                if (weightArr[i] > j) { // 物品重量大于 背包容量
                    dp[i][j] = dp[i - 1][j]   // if object weight < j , then use top item
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weightArr[i]] + valueArr[i])
                }
            }
        }


        val addedList = ArrayList<Int>()
        var j = w
        for (i in n downTo 0) {
            if (dp[i - 1][j] >= dp[i][j]) {
                j -= weightArr[j]
            }
        }
        return dp[n][w]
    }

    fun knapStackarray(N: Int, W: Int) {
        val weightArr = arrayOf(1, 3, 4)
        val valueArr = arrayOf(15, 20, 30)

        val dp = Array(4) { 0 }
        for (i in 1..N) {
            for (j in W downTo weightArr[i]) { // 只有j容量大于当前物品的容量，才会考虑添加到数组中，更新当前cell的值，否则就直接用上一层的值
                dp[j] = Math.max(dp[j],dp[j-weightArr[i]+valueArr[i]])
            }
        }
    }

}

fun main() {
    Knapstack01().knap01()
}