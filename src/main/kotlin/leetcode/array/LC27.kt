package leetcode.array

class LC27 {
    fun removeElement(nums: IntArray, element: Int): Int {
        var fastIndex = 0
        var slowIndex = 0  // 都是从开始,
        while (fastIndex < nums.size) {
            if (nums[fastIndex] != element) {
                if (slowIndex!=fastIndex){ // 同一个位置，没必要赋值
                    nums[slowIndex] = nums[fastIndex]
                }
                slowIndex++ // 只有不同的时候 slow指针移动
            }
            fastIndex++
        }
        return slowIndex
    }

//    fun removeElement(nums: IntArray, element: Int): Int {
//        var slowIndex = 0
//        for (fastIndex in nums.indices) {
//            if (element !== nums.get(fastIndex)) {
//                nums[slowIndex++] = nums[fastIndex]
//            }
//        }
//        return slowIndex
//    }
}