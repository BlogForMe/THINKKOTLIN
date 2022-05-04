package leetcode.array

class LC209 {
    fun minSubArrayLen(target: Int, nums: IntArray): Int {
        var sum = 0
        var leftP = 0;
        var result = Int.MAX_VALUE
        for (rightP in nums.indices) {
            sum += nums[rightP]
            while (sum >= target) {
                val subLength = rightP - leftP + 1
                if (subLength < result) result = subLength
                sum -= nums[leftP++]
            }
        }
        if (result == Int.MAX_VALUE) result = 0
        return result
    }
}