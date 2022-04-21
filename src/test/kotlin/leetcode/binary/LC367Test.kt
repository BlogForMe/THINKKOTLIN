package leetcode.binary


import org.junit.Test
import org.junit.jupiter.api.Assertions.*

internal class LC367Test {

    @Test
    fun isPerfectSquare() {
//        assertEquals(true, LC367().isPerfectSquare(16))
//        assertEquals(false, LC367().isPerfectSquare(14))
        assertEquals(false, LC367().isPerfectSquare(2147483647))
    }
}