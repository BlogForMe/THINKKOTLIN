package leetcode.linkedlist

import org.junit.Test

import org.junit.Assert.*

class LC242Test {

    @Test
    fun isAnagram() {
        val s = "anagram"
        val t = "nagaram"
        assert(LC242().isAnagram(s, t))
    }
}