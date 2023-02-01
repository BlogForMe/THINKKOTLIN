package leetcode.greedy

class LC55 {
    fun canJump(nums: IntArray): Boolean {
        var coverArea = 0
        for (i in 0..coverArea) { // 这里是coverArea,需要确定能走多少步
            coverArea = (i + nums[i]).coerceAtLeast(coverArea) //新的范围和 之前的范围做比较
            if (coverArea >= nums.size - 1) {
                return true
            }
        }
        return false
    }
}