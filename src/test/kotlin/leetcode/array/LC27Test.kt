package leetcode.array

import leetcode.ext.printIntArray
import org.junit.Test


class LC27Test {

    @Test
    fun removeElement() {
//        val nums = intArrayOf(3, 2, 2, 3)
        val nums = intArrayOf(5, 2, 2, 3, 4)
        LC27().removeElement(nums, 3)
        nums.printIntArray()
    }
}