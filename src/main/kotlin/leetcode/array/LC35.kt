package leetcode.array

class LC35 {
    fun searchInsert(nums: IntArray, target: Int): Int {
        var right = nums.size
        var left = 0
        while (left < right) {
            val mid = left + (right - left) / 2
            if (nums[mid] == target) {
                return mid
            } else if (nums[mid] > target) {
                right = mid
            } else {
                left = mid + 1 //加1
            }
        }
        return left
    }

    fun searchInsert1(nums: IntArray, target: Int): Int {
        var right = nums.size - 1
        var left = 0
        while (left <= right) {
            val mid = left + (right - left) / 2
            if (nums[mid] == target) {
                return mid
            } else if (nums[mid] > target) {
                right = mid - 1
            } else if (nums[mid] < target) {
                left = mid + 1
            }
        }
        return left
    }

    fun searchInsert2(nums: IntArray, target: Int): Int {
        var right = nums.size
        var left = 0
        while (left < right) {
            val mid = left + ((right - left) shr  2)
            if (nums[mid] == target) {
                return mid
            } else if (nums[mid] > target) {
                right = mid
            } else {
                left = mid + 1 //加1
            }
        }
        return left
    }
}

fun main() {
//    println(Solution().searchInsert1(intArrayOf(1, 3, 5, 6), 5))
//    println(Solution().searchInsert1(intArrayOf(1, 3, 5, 6), 2))
//    println(Solution().searchInsert1(intArrayOf(1, 3, 5, 6), 7))

//    println(Solution().searchInsert(intArrayOf(1, 3, 5, 6), 5))
//    println(Solution().searchInsert(intArrayOf(1, 3, 5, 6), 2))
//    println(Solution().searchInsert(intArrayOf(1, 3, 5, 6), 7))


    println(LC35().searchInsert2(intArrayOf(1, 3, 5, 6), 5))
    println(LC35().searchInsert2(intArrayOf(1, 3, 5, 6), 2))
    println(LC35().searchInsert2(intArrayOf(1, 3, 5, 6), 7))
}