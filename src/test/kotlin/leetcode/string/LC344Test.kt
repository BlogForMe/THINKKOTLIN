package leetcode.string

import org.junit.Test

import org.junit.Assert.*

class LC344Test {

    @Test
    fun reverseString() {
        val charArrayOf = charArrayOf('h', 'e', 'l', 'l', 'o')
        LC344().reverseString(charArrayOf)
        assertArrayEquals(charArrayOf('o', 'l', 'l', 'e', 'h'), charArrayOf)

        val charArrayOf1 = charArrayOf('H', 'a', 'n', 'n', 'a', 'h')
        LC344().reverseString(charArrayOf1)
        assertArrayEquals(charArrayOf('h','a','n','n','a','H'), charArrayOf1)
    }
}