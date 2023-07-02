package leetcode.dp

class LC509 {


    /**
     * 随想录视频思路解法1
     */
    fun fib1(n: Int): Int {
//        println(n)
        if (n == 0) return 0
        else if (n == 1) return 1
        val dp = IntArray(n + 1)
        dp[0] = 0
        dp[1] = 1
        for (i in 2..n) {
            dp[i] = dp[i - 1] + dp[i - 2]
//            println(" dp[n - 1]= ${ dp[n - 1]}  dp[n - 2]= ${dp[n - 2]}")
        }
        return dp[n]
    }


    /**
     * 随想录视频思路解法2
     */
    fun fib(n: Int): Int {
        if (n == 0) return 0
        else if (n == 1) return 1
        val dp = IntArray(2)
        dp[0] = 0
        dp[1] = 1
        var sum = 0
        for (i in 2..n) {
            sum = dp[0] + dp[1]
            println("sum $sum  dp[0]= ${dp[0]} , dp[1]= ${dp[1]}")
            dp[0] = dp[1]
            dp[1] = sum
        }
        return sum
    }


    /* fun fib(n: Int): Int {
         var pre1 = 0
         var pre2 = 1
         var sum = 0

         if (n == 0) return 0
         else if (n == 1) return 1
         for (i in 2..n) {
             sum = pre1 + pre2  // 得到当前n的num
             pre1 = pre2     //移动指针
             pre2 = sum
         }
         return sum
     }*/

//    fun fib(n: Int): Int {
//        val memory = IntArray(n + 1)
//        if (memory[n] != 0) {
//            return memory[n]
//        } else if (n == 0) return 0
//        else if (n == 1) return 1
//
//        memory[n] = fib(n - 1) + fib(n - 2)
//        return memory[n]
//    }
//
//
//    fun fib(n: Int): Int {
//        if (n == 0) return 0
//        if (n == 1) return 1
//        return fib(n - 1) + fib(n - 2)
//    }


}