package leetcode.string

import junit.framework.TestCase

class OFFER58Test : TestCase() {

    fun testReverseLeftWords() {
        assertEquals("cdefgab",OFFER58().reverseLeftWords("abcdefg",2))
        assertEquals("umghlrlose",OFFER58().reverseLeftWords("lrloseumgh",6))
    }
}