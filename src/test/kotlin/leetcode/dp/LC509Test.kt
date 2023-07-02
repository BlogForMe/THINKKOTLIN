package leetcode.dp

import org.junit.Assert
import org.junit.jupiter.api.Test

class LC509Test {

    @Test
    fun fib() {
        Assert.assertEquals(1, LC509().fib(2))
        Assert.assertEquals(2, LC509().fib(3))
        Assert.assertEquals(3, LC509().fib(4))
    }
}