package leetcode

class LC69 {
    fun mySqrt(x: Int): Int {
        var left = 0;
        var right = x;
        while (left <= right) {
            val mid = left + (right - left) / 2
            if (mid * mid == x) {
                return mid
            } else if (mid * mid > x) {
                right = mid - 1
            } else if (mid * mid < x) {
                left = mid
            }
        }
        return left;
    }
}

fun main() {
//    println(LC69().mySqrt(4))
    println(LC69().mySqrt(8))

}