package leetcode.array

class LC977 {
    fun sortedSquares(nums: IntArray): IntArray {
        var left = 0
        var right = nums.size - 1
        var index = nums.size - 1
        val arrayNew = IntArray(nums.size)
        while (left <= right) {
            val leftSquare = nums[left] * nums[left]
            val rightSquare = nums[right] * nums[right]
            if (leftSquare <= rightSquare) {
                arrayNew[index--] = rightSquare
                right--
            } else {
                arrayNew[index--] = leftSquare
                left++
            }
        }
        return arrayNew
    }
}