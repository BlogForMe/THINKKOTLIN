package leetcode.linkedlist

import leetcode.ext.ListNode
import org.junit.Test

class LC203Test {

    @Test
    fun removeElements() {
         println(LC203().removeElements(ListNode(intArrayOf(1,2,6,3,4,5,6)),6))
         println(LC203().removeElements(ListNode(intArrayOf(7,7,7,7)),7))
    }
}