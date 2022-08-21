package leetcode.linkedlist

import leetcode.ext.ListNode
import org.junit.Test

class LC19Test {

    @Test
    fun removeNthFromEnd() {

        val removeNthFromEnd = LC19().removeNthFromEnd(ListNode(intArrayOf(1, 2, 3, 4, 5)), 2)
        println(removeNthFromEnd)

        val removeNthFromEnd1 = LC19().removeNthFromEnd(ListNode(intArrayOf(1)), 1)
        println(removeNthFromEnd1)

        val removeNthFromEnd2 = LC19().removeNthFromEnd(ListNode(intArrayOf(1,2)), 1)
        println(removeNthFromEnd2)
    }
}