package leetcode.greedy

import org.junit.Assert
import org.junit.Test


class LC55Test {

    @Test
    fun canJump() {
        Assert.assertEquals(true, LC55().canJump(intArrayOf(2, 3, 1, 1, 4)))
//        Assert.assertEquals(false, LC55().canJump(intArrayOf(3, 2, 1, 0, 4)))
//        Assert.assertEquals(false, LC55().canJump(intArrayOf(0,2,3)))
    }
}