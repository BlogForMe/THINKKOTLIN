package leetcode.backtrack.combination

class LC78 {

    val result = ArrayList<List<Int>>()
    val path = ArrayList<Int>()
    fun subsets(nums: IntArray): List<List<Int>> {
        backTrack(nums, 0)
        return result
    }

    private fun backTrack(nums: IntArray, startIndex: Int) {
        result.add(path.toList()) // 这棵树所有的步长，都添加
        for (i in startIndex until nums.size) {
            path.add(nums[i])
            backTrack(nums, i + 1)
            path.remove(nums[i])
        }
    }
}