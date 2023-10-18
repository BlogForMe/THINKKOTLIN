package leetcode.dp

import org.junit.Assert
import org.junit.jupiter.api.Test

class LC494Test {
    @Test
    fun findTargetSumWays() {
     Assert.assertEquals(5,LC494().findTargetSumWays(intArrayOf(1, 1, 1, 1, 1), 3))
    }
}