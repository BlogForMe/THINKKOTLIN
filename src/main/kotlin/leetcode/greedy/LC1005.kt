package leetcode.greedy

import java.util.*

class LC1005 {

    fun largestSumAfterKNegations(nums: IntArray, k: Int): Int {
        val typedArray = nums.toTypedArray() // 转成数组
        Arrays.sort(typedArray, Comparator.comparingInt(Math::abs)) // 按照绝对值排序
        var k = k
        for (i in typedArray.indices) {
            if (k > 0 && typedArray[i] < 0) {  // 碰到数组中>0的数
                typedArray[i] *= -1
                k--
            }
        }
        Arrays.sort(typedArray)
        if (k % 2 > 0) {
            typedArray[0] *= -1
        }
        var sum = 0
        for (value in nums) {
            sum += value
        }
        return sum
    }


    fun largestSumAfterKNegations1(nums: IntArray, k: Int): Int {
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