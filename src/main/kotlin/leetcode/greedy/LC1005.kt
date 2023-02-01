package leetcode.greedy

import java.util.*

class LC1005 {
    fun largestSumAfterKNegations(nums: IntArray, k: Int): Int {
        Arrays.sort(nums)
        var balanceK = 0
        for (i in 0 until k) {
            if (i >= nums.size || nums[i] > 0) {
                balanceK = k - i
                break
            }
            nums[i] = Math.abs(nums[i])
        }
        Arrays.sort(nums)
        if (balanceK > 0 && (balanceK % 2) > 0) {
            nums[0] = -nums[0]
        }
        var sum = 0
        for (value in nums) {
            sum += value
        }
        return sum
    }
}