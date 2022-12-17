package leetcode.backtrack.combination

import java.util.Arrays

class LC90 {
    private val result = ArrayList<List<Int>>()
    private val path = ArrayList<Int>()
    fun subsetsWithDup(nums: IntArray): List<List<Int>> {
        Arrays.sort(nums)
        val used = BooleanArray(nums.size)
        backTrack(nums, used, 0)
        return result
    }

    private fun backTrack(nums: IntArray, used: BooleanArray, startIndex: Int) {
        result.add(path.toList())
        for (i in startIndex until nums.size) {
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue
            }
            used[i] = true
            path.add(nums[i])
            backTrack(nums, used, i + 1)
            path.remove(nums[i])
            used[i] = false
        }
    }
}