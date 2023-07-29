package leetcode.dp

import org.junit.Assert
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class LC62Test {

    @Test
    fun uniquePaths() {
      Assert.assertEquals(28,LC62().uniquePaths(3,7))
      Assert.assertEquals(3,LC62().uniquePaths(3,2))
      Assert.assertEquals(28,LC62().uniquePaths(7,3))
      Assert.assertEquals(6,LC62().uniquePaths(3,3))
    }
}