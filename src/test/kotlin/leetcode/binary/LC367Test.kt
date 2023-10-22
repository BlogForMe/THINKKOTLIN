package leetcode.binary


import leetcode.array.LC367
import org.junit.Assert.assertEquals
import org.junit.Test

internal class LC367Test {

    @Test
    fun isPerfectSquare() {
//        assertEquals(true, LC367().isPerfectSquare(16))
//        assertEquals(false, LC367().isPerfectSquare(14))
        assertEquals(false, LC367().isPerfectSquare(2147483647))
    }
}