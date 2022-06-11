package leetcode.string

import org.junit.Test

import org.junit.Assert.*

class LC541Test {

    @Test
    fun reverseStr() {
        assertEquals("bacdfeg", LC541().reverseStr("abcdefg", 2))
        assertEquals("bacd", LC541().reverseStr("abcd", 2))
        assertEquals("a", LC541().reverseStr("a", 2))
    }
}