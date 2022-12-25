package leetcode.backtrack.combination

import java.util.*

class LC47 {
    private val path = ArrayList<Int>()
    private val result = ArrayList<List<Int>>()
    fun permuteUnique(nums: IntArray): List<List<Int>> {
        Arrays.sort(nums)
//        nums.printIntArray()
        val used = BooleanArray(nums.size)
        backTrack(nums, used)
        return result
    }

//    private fun backTrack(nums: IntArray, used: BooleanArray) {
//        println(path)
//        if (path.size == nums.size) {
//            result.add(path.toList())
//            return
//        }
//        for ((index, value) in nums.withIndex()) {
//            if (used[index] || (index > 0 && nums[index] == nums[index - 1] && !used[index - 1])) {
//                continue
//            }
//            used[index] = true
//            path.add(value)
//            backTrack(nums, used)
//            used[index] = false
//            path.remove(value)
//        }
//    }

    private fun backTrack(nums: IntArray, used: BooleanArray) {
        println(path)
        if (path.size == nums.size) {
            result.add(path.toList())
            return
        }
        for (index in nums.indices) {
            if ((index > 0 && nums[index] == nums[index - 1] && !used[index - 1])) {
                continue
            }
            if (used[index]) {
                continue
            }
            used[index] = true
            path.add(nums[index])
            backTrack(nums, used)
            path.removeAt(path.lastIndex) // 用path.remove(value)是有问题的，会把所有的这个元素删除掉，46没问题是因为没有重复元素，leetcode removeLast() cannot build
            used[index] = false
        }
    }
}

