package leetcode.string

import junit.framework.TestCase
import java.util.*

class LC151Test : TestCase() {

    fun testReverseWords() {
        assertEquals("blue is sky the", LC151().reverseWords("the sky is blue"))
        assertEquals("world hello", LC151().reverseWords("  hello world  "))
        assertEquals("example good a", LC151().reverseWords("a good   example"))
    }

    fun testReverseWords2() {
        assertEquals("blue is sky the", LC151().reverseWords2("the sky is blue"))
        assertEquals("world hello", LC151().reverseWords2("  hello world  "))
        assertEquals("example good a", LC151().reverseWords2("a good   example"))
    }


    fun testArrayDeque() {
//        String s = "the sky is blue";
//        new Solution().reverseWords(s);
        val deque: Deque<String?> = ArrayDeque()
        deque.offerFirst("the")
        deque.offerFirst("sky")
        deque.offerFirst("is")
        deque.offerFirst("smile")
        val join = java.lang.String.join(" ", deque)
        println(join)
    }


    fun printAscii() {
        val data = ' '
        println(data.code)
        println('A'.code)
        "the sky is blue".forEach { print("${it.code} ") }
        println()
        "the   sky is blue".forEach { print("${it.code} ") }
    }

}