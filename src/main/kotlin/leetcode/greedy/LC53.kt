package leetcode.greedy

class LC53 {
    fun maxSubArray(nums: IntArray): Int {
        var result = 0
        var maxResult = Int.MIN_VALUE
        for (pIndex in nums.indices) {
            result += nums[pIndex]
            maxResult = maxResult.coerceAtLeast(result)
            if (result < 0) {
                result = 0
            }
        }
        return maxResult
    }
}