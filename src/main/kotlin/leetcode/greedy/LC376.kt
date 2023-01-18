package leetcode.greedy

class LC376 {
    fun wiggleMaxLength(nums: IntArray): Int {
        if (nums.size <= 1) {
            return nums.size
        }
        var preDiff = 0 //前一对差值
        var curveDiff = 0
        var result = 1
        for (i in 1 until nums.size) { // 第一个数已经计入摆动序列了，所以从1开始
            curveDiff = nums[i] - nums[i - 1] // 因为要给值给preDiff，所以从i开始，随想录c++解法是从0开始的。
            if ((preDiff >= 0 && curveDiff < 0) || (preDiff <= 0 && curveDiff > 0)) {
                result++
                preDiff = curveDiff
            }
        }
        return result
    }
}