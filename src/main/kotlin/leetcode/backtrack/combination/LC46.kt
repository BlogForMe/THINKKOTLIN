package leetcode.backtrack.combination

class LC46 {

    private val result = ArrayList<List<Int>>()
    private val path = ArrayList<Int>()
    fun permute(nums: IntArray): List<List<Int>> {
        val size = nums.size
        val used = BooleanArray(size)
        backTrack(nums, used)
        return result
    }

    private fun backTrack(nums: IntArray, used: BooleanArray) {
        println(path)
        if (path.size == nums.size) {
            result.add(path.toList())
            return
        }
        for ((index, value) in nums.withIndex()) {
            if (used[index]) {
                continue
            }
            path.add(nums[index])
            used[index] = true
            backTrack(nums, used)
            path.remove(nums[index])
            used[index] = false
        }
    }

    private fun totalUsed(used: BooleanArray): Boolean {
        return used.contains(false).not()
    }
}