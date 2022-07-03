package leetcode.string

import junit.framework.TestCase

class LC459Test : TestCase() {

    fun testRepeatedSubstringPattern() {
        assert(LC459().repeatedSubstringPattern("asdfasdfasdf"))
        assert(LC459().repeatedSubstringPattern("abab"))
        assertFalse(LC459().repeatedSubstringPattern("aba"))
        assert(LC459().repeatedSubstringPattern("abcabcabcabc"))

    }
}