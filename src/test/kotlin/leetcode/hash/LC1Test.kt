package leetcode.hash

import org.junit.Test

import org.junit.Assert.*

class LC1Test {

    @Test
    fun twoSum() {
        val twoSum = LC1().twoSum(intArrayOf(2, 7, 11, 15), 9)
        println(twoSum)
        assertArrayEquals(intArrayOf(0, 1), LC1().twoSum(intArrayOf(2, 7, 11, 15), 9)) // 顺序是可以打乱的intArrayOf(1, 0) 也行

//        assertArrayEquals(intArrayOf(1, 2), LC1().twoSum(intArrayOf(3, 2, 4), 6))
//        assertArrayEquals(intArrayOf(0, 1), LC1().twoSum(intArrayOf(3, 3), 6))
    }
}