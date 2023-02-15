package leetcode.greedy

import org.junit.Assert
import org.junit.Test


class LC860Test {

    @Test
    fun lemonadeChange() {
        Assert.assertEquals(
            true,
            LC860().lemonadeChange(intArrayOf(5, 5, 10, 20, 5, 5, 5, 5, 5, 5, 5, 5, 5, 10, 5, 5, 20, 5, 20, 5))
        )

    }
}