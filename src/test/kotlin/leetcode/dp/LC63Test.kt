package leetcode.dp

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class LC63Test {

    @Test
    fun uniquePathsWithObstacles() {
        val arrayListOf = arrayOf(intArrayOf(0, 0, 0), intArrayOf(0, 1, 0), intArrayOf(0, 0, 0),intArrayOf(0, 0, 0))
        LC63().uniquePathsWithObstacles(arrayListOf)

    }
}