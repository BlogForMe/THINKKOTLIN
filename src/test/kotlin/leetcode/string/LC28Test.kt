package leetcode.string

import junit.framework.TestCase

class LC28Test : TestCase() {

    fun testStrStr() {
        assertEquals(2, LC28().strStr("hello", "ll"))
        assertEquals(-1, LC28().strStr("aaaaa", "bba"))
        assertEquals(0, LC28().strStr("a", "a"))
        assertEquals(-1, LC28().strStr("aaa", "aaaa"))

    }
}