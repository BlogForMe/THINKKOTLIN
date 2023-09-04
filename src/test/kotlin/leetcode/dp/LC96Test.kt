package leetcode.dp

import org.junit.Assert.assertEquals
import org.junit.Test

class LC96Test {

    @Test
    fun numTreesTest() {
        assertEquals(1, LC96().numTrees(1))
        assertEquals(2, LC96().numTrees(2))
        assertEquals(5, LC96().numTrees(3))
    }
}