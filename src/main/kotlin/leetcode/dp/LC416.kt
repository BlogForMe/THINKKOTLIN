package leetcode.dp

class LC416 {
    fun canPartition(nums: IntArray): Boolean {
        val dp = IntArray(nums.size + 1)
        var sum = 0
        nums.forEach {
            sum += it
        }
        sum /= 2
        for (i in 0..nums.size) {
            for (j in sum downTo 0) {
                if (j > nums[i]){
                    Math.max(nums[i])nums[j-nums[i]]+nums[i]
                }
            }
        }
    }
}