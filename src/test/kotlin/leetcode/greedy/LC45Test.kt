package leetcode.greedy

import org.junit.Assert
import org.junit.Test


class LC45Test {

    @Test
    fun jump() {
        Assert.assertEquals(2, LC45().jump(intArrayOf(2, 3, 1, 1, 4)))
    }
}