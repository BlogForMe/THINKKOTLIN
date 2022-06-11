package leetcode.hash

import java.util.*
import kotlin.collections.ArrayList

class LC15 {
    fun threeSum(nums: IntArray): List<List<Int>> {
        Arrays.sort(nums)
        val hashSetOf = hashSetOf<List<Int>>()
        nums.forEachIndexed { i, value ->
            val target = -nums[i]
            var left = i + 1
            var right = nums.size - 1
            while (left < right) {
                if (nums[left] + nums[right] < target) {
                    left++
                } else if (nums[left] + nums[right] > target) {
                    right--
                } else {
                    val list = arrayListOf(nums[i], nums[left], nums[right])
                    hashSetOf.add(list)
                    right--  // 为了防止重复元素，所以这两个也需要移动
                    left++
                }
            }
        }
//        return hashSetOf.toList()
        return ArrayList(hashSetOf) // 这里时间复杂度是 o(n),第2种解法是对这里进行优化
    }

    //超出时间限制
    fun threeSum2(nums: IntArray): List<List<Int>> {
        Arrays.sort(nums)
        val ans = ArrayList<List<Int>>()
        for (i in nums.indices) {
            if (i > 0 && nums[i] == nums[i - 1]) { // 相同的target元素直接pass
                continue
            }
            val target = -nums[i]
            var left = i + 1
            var right = nums.size - 1
            while (left < right) {
                if (nums[left] + nums[right] < target) {
                    left++
                } else if (nums[left] + nums[right] > target) {
                    right--
                } else {
                    val list = arrayListOf(nums[i], nums[left], nums[right])
                    ans.add(list)
                    right--  // 为了防止重复元素，所以这两个也需要移动
                    left++
                    while (left < right && nums[left] == nums[left - 1]) continue // 这两句放在while循环外面 退出不了,拿到结果后， 相同的元素pass
                    while (left < right && nums[right] == nums[right - 1]) continue
                }
            }
        }
        return ans
    }
}