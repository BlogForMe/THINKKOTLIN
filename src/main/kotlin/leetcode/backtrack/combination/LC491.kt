package leetcode.backtrack.combination

class LC491 {
    private val result = ArrayList<List<Int>>()
    private val path = ArrayList<Int>()

    fun findSubsequences(nums: IntArray): List<List<Int>> {
        backTrack(nums, 0, 0)
        return result
    }

//    private fun backTrack(nums: IntArray, startIndex: Int, layer: Int) {
//        if (path.size > 1) {                      //  至少有两个元素
//            result.add(path.toList())
//        }
//        val set = mutableSetOf<Int>()             // 树层中是否包含 相同的元素。
//        for (i in startIndex until nums.size) {
////            println("startIndex $startIndex set $set")
//            if (layer == 0) {
//                println("layer  set $set")
//            }
//            if ((path.isNotEmpty() && nums[i] < path.last()) || set.contains(nums[i])) { // 小于上一个元素，这个分支以下不用走了， set树层中包含相同的与元素。
//                continue
//            }
//            set.add(nums[i])  //因为是判断树层，而且是每一层都局部会new 一个set，所以这个没有回溯。
//            path.add(nums[i])
//            backTrack(nums, i + 1, layer + 1)
//            path.remove(nums[i])
//        }
//    }

    private fun backTrack(nums: IntArray, startIndex: Int, layer: Int) {
        if (path.size > 1) {
            result.add(path.toList())
        }
        val used = IntArray(201) // -100 <= nums[i] <= 100 ， 包括 0
        for (i in startIndex until nums.size) {
            if ((path.isNotEmpty() && nums[i] < path.last()) || used[nums[i] + 100] == 1) {
                continue
            }
            used[nums[i] + 100] = 1
            path.add(nums[i])
            backTrack(nums, i + 1, layer + 1)
            path.remove(nums[i])
        }
    }
}