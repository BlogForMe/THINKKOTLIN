package leetcode.dp

import org.junit.Assert
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class LC70Test {

    @Test
    fun climbStairsTest() {
        Assert.assertEquals(1, LC70().climbStairs(1))
        Assert.assertEquals(2,  LC70().climbStairs(2))
        Assert.assertEquals(3,  LC70().climbStairs(3))
    }
}