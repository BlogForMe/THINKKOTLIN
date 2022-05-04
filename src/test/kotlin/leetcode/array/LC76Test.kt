package leetcode.array

import org.junit.Test

import org.junit.Assert.*

class LC76Test {

    @Test
    fun minWindow() {
        assertEquals("BANC", LC76().minWindow("ADOBECODEBANC", "ABC"))
        assertEquals("a", LC76().minWindow("a", "a"))
        assertEquals("", LC76().minWindow("a", "aa"))
        assertEquals("cwae", LC76().minWindow("cabwefgewcwaefgcf", "cae"))

    }
}