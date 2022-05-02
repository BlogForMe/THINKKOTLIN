package leetcode.array

class LC283 {
    fun moveZeroes(nums: IntArray): Unit {
        var slowIndex = 0
        for (fastIndex in 1 until nums.size) {
            if (nums[fastIndex] != 0 && nums[slowIndex] == 0) { //符合条件就交换位置，慢指针让它在后面的条件移动
                nums[slowIndex] = nums[fastIndex]
                nums[fastIndex] = 0
            }
            if (nums[slowIndex] != 0) { // 慢指针 !=0就移动
                slowIndex++
            }
        }
    }
}