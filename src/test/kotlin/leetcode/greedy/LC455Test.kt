package leetcode.greedy

import org.junit.Assert
import org.junit.Test


class LC455Test {

    @Test
    fun findContentChildren() {
        Assert.assertEquals(2, LC455().findContentChildren(intArrayOf(10, 9, 8, 7), intArrayOf(5, 6, 7, 8)))
    }
}