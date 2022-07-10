package leetcode.string

import junit.framework.TestCase

class LC20Test : TestCase() {

    fun testIsValid() {
        assert(LC20().isValid("()"))
        assert(LC20().isValid("()[]{}"))
        assertFalse(LC20().isValid("(]"))
        assertFalse(LC20().isValid("([)]"))
        assert(LC20().isValid("{[]}"))
    }
}