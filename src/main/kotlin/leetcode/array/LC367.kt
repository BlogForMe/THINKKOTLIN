package leetcode.array


class LC367 {
    fun isPerfectSquare(num: Int): Boolean {
        var left = 1
        var right = num
        while (left <= right) {
            var mid = left + (right - left) / 2
            val square = mid * mid.toLong()
            if (square > num) {
                right = mid - 1
            } else if (square < num) {
                left = mid + 1
            } else {
                return true
            }
        }
        return false
    }
}

