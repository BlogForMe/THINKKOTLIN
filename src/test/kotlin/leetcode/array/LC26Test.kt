package leetcode.array

import org.junit.Test


internal class LC26Test {

    @Test
    fun removeDuplicates() {
//        val nums1 = intArrayOf(0, 0, 1, 1, 1, 2, 2, 3, 3, 4)
//        LC26().removeDuplicates(nums1)
//        println(nums1)

//        val nums2 = intArrayOf(0, 1, 2, 2, 3, 4, 4, 5)
//        val nums2 = intArrayOf(0,0,1,1,1,2,2,3,3,4)
        val nums2 = intArrayOf(1, 1, 2)
        assert(LC26().removeDuplicates1(nums2) == 2)
        println(nums2)
    }
}