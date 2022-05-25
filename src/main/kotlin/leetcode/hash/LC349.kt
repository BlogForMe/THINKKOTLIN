package leetcode.hash

class LC349 {
    fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
        val set = hashSetOf<Int>()
        nums1.forEach {
            set.add(it)
        }
        val anSet = hashSetOf<Int>()
        nums2.forEach {
            if (set.contains(it)) {
                anSet.add(it)
            }
        }
        return anSet.toIntArray()
    }
}