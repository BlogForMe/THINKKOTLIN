package leetcode.string

import junit.framework.TestCase
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert

class LC28Test : TestCase() {

    fun testStrStr() {
        assertEquals(2, LC28().strStr("hello", "ll"))
        assertEquals(-1, LC28().strStr("aaaaa", "bba"))
        assertEquals(0, LC28().strStr("a", "a"))
        assertEquals(-1, LC28().strStr("aaa", "aaaa"))

    }

    fun testInitNext() {
        MatcherAssert.assertThat(LC28().initNext("aabaaf"), equalTo(intArrayOf(0, 1, 0, 1, 2, 0)))
    }

    fun testStrStrKmp(){
//        val strStrKmp = LC28().strStrKmp("aabaabaafa", "aabaaf")
        assertEquals(2,LC28().strStrKmp("hello", "ll"))
        assertEquals(3,LC28().strStrKmp("aabaabaafa", "aabaaf"))

    }
}