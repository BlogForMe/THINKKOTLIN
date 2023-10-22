package leetcode.array

class LC34 {
    fun searchRange(nums: IntArray, target: Int): IntArray {
        if (nums.isEmpty()) {
            return intArrayOf(-1, -1)
        }
        //目前元素的第一个元素
        val leftPosition = findFirstElement(nums, target)
        if (leftPosition == -1) {
            return intArrayOf(-1, -1)
        }
        //目标元素的最后一个元素
        val rightPosition = findLastElement(nums, target)
        return intArrayOf(leftPosition, rightPosition)
    }

    private fun findFirstElement(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size - 1
        while (left < right) {
            val mid = left + (right - left) / 2
            if (nums[mid] == target) {
                // 查找范围 [left, mid] 目标元素的右边,一定不是目标元素出现的第一个位置
                right = mid
            } else if (nums[mid] < target) {
                //查找范围 [mid+1,right]
                left = mid + 1
            } else if (nums[mid] > target) {
                // [left,mid-1]
                right = mid - 1
            }
        }
        if (nums[left] == target) { //nums[right] intArrayOf(2,2), 1) 会越界
            return right
        }
        return -1
    }

    private fun findLastElement(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size - 1
        while (left < right) {
            val mid = (left + right + 1) / 2    //为什么需要上取整数
            if (nums[mid] == target) {
                // [mid,right] 目标元素左边一定不是 最后一个出现的元素
                left = mid
            } else if (nums[mid] < target) {
                // [mid+1,right]
                left = mid + 1
            } else if (nums[mid] > target) {
                // [left,mid-1]
                right = mid - 1
            }
        }
        return left
    }

}

fun main() {
//    println(LC34().searchRange(intArrayOf(5, 7, 7, 8, 8, 10), 8).printIntArray())
//    println(LC34().searchRange(intArrayOf(5, 7, 7, 8, 8, 10), 6).printIntArray())
//    println(LC34().searchRange(intArrayOf(2,2), 1).printIntArray())
//    for (i in 1..20) {
//        for (i in 0..9) {
//            print(i)
//        }
//    }
//    println()
//    println("01234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789".length)
}

