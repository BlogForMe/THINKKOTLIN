package leetcode.greedy

import org.junit.Assert
import org.junit.Test


class LC53Test {

    @Test
    fun maxSubArray() {
//        Assert.assertEquals(6, LC53().maxSubArray(intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)))
//        Assert.assertEquals(1, LC53().maxSubArray(intArrayOf(1)))
//        Assert.assertEquals(23, LC53().maxSubArray(intArrayOf(5, 4, -1, 7, 8)))
        Assert.assertEquals(-1, LC53().maxSubArray(intArrayOf(-1)))
//        Assert.assertEquals(-1, LC53().maxSubArray(intArrayOf(-2,-1)))
    }
}