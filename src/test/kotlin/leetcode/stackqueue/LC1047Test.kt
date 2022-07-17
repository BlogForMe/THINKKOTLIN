package leetcode.stackqueue

import junit.framework.TestCase

class LC1047Test : TestCase() {

    fun testRemoveDuplicates() {
        assertEquals("ca",LC1047().removeDuplicates("abbaca"))
    }
}