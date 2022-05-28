package leetcode.hash


class LC1 {
    // {2,11,7,15}
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = hashMapOf<Int, Int>()
        nums.forEachIndexed { index, value ->
            if (map.containsKey(target - nums[index])) {    //假如index = 0,加入map,当index==2时, 9 - 7 = 2 就可以在map中找到了
                return intArrayOf(index, map[target - nums[index]]!!) //相当于另一个数先加入map，找对应的数
            }
            map[value] = index
        }
        throw RuntimeException("do not have the array")
    }

//    fun twoSum(nums: IntArray, target: Int): IntArray {
//        val map = hashMapOf<Int, Int>()
//        nums.forEachIndexed { index, value ->
//            map[index] = value
//        }
//        Arrays.sort(nums)
//
//        var left = 0
//        var right = nums.size - 1
//        while (left < right) {
//            if (nums[left] + nums[right] > target) {
//                right--
//            } else if (nums[left] + nums[right] < target) {
//                left++
//            } else {
//                return intArrayOf(map[nums[left]]!!, map[nums[right]]!!)
//            }
//        }
//        return intArrayOf()
//    }
}