package leetcode.array

import org.junit.Test


internal class LC283Test {

    @Test
    fun moveZeroes() {
        val nums = intArrayOf(0, 1, 0, 3, 12)
//        val nums = intArrayOf(1, 0, 1)
        LC283().moveZeroes(nums)
        println(nums)
    }
}