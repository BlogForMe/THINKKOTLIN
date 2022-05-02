package leetcode.array

class LC26 {
    //官方解法，不好理解
    fun removeDuplicates(nums: IntArray): Int {
        if (nums.isEmpty()){
            return 0
        }
        var slowIndex = 1
        for (fastIndex in 1 until nums.size) {
            if (nums[fastIndex] != nums[slowIndex - 1]) {
                nums[slowIndex] = nums[fastIndex]
                slowIndex++;
            }
        }
        return slowIndex
    }

    //这个更好理解 https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/solution/shuang-zhi-zhen-shan-chu-zhong-fu-xiang-dai-you-hu/
    fun removeDuplicates1(nums: IntArray): Int {
        if (nums.isEmpty()){
            return 0
        }
        var slowIndex = 0
        for (fastIndex in 1 until nums.size) {
            if (nums[fastIndex] != nums[slowIndex]) {
                nums[slowIndex + 1] = nums[fastIndex] // 慢指针的后一个位置，放上 快指针不同的值
                slowIndex++
            }
        }
        return slowIndex+1
    }

}
