package leetcode.linkedlist

import leetcode.ext.ListNode
import org.junit.Test

class LC24Test {

    @Test
    fun swapPairs() {
        val swapPairs = LC24().swapPairs(ListNode(intArrayOf(1, 2, 3, 4)))
        println(swapPairs)
        val swapPairs2 = LC24().swapPairs(ListNode(intArrayOf(1)))
        println(swapPairs2)
    }
}