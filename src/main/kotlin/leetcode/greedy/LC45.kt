package leetcode.greedy

class LC45 {

    fun jump(nums: IntArray): Int {
        var nextCover = 0
        var count = 0
        var currentCover = 0
        for (i in 0 until nums.size - 1) {
            nextCover = Math.max(i + nums[i], nextCover)
            if (i == currentCover) {
                currentCover = nextCover
                count++
            }
        }
        return count
    }

    fun jump1(nums: IntArray): Int {
        var maxCover = 0
        var count = 0
        for (i in 0..maxCover) {
            if (i + nums[i] > maxCover) {
                maxCover = i + nums[i]
            } else {
                count++
            }

            if (maxCover >= nums.size) {
                println("count $count")
                return count
            }
        }
        return count
    }
}