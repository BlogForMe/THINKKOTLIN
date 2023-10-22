package leetcode.array

// 新建02再写一次
class LC69_01 {
    fun mySqrt(x: Int): Int {
        var left = 0
        var right = x
        while (left < right) {
            val mid = left + (right - left + 1) / 2
            // 调试语句开始
//            try {
//                Thread.sleep(1000);
//            } catch (e: InterruptedException) {
//                e.printStackTrace()
//            }
//            println("left = $left, right = $right, mid = $mid")

//            链接：https://leetcode-cn.com/problems/sqrtx/solution/er-fen-cha-zhao-niu-dun-fa-python-dai-ma-by-liweiw/
            if (mid * mid == x) {
                return mid
            } else if (mid * mid.toLong() < x) {
                left = mid
            } else if (mid * mid.toLong() > x) {
                right = mid - 1
            }
        }
        return left;
    }
}

fun main() {
    println(LC69_01().mySqrt(4))
    println(LC69_01().mySqrt(8))
    println(LC69_01().mySqrt(2147395599))
    println(LC69_01().mySqrt(2147483647))
}