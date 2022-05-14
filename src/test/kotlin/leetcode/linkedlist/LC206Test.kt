package leetcode.linkedlist

import leetcode.tool.ListNode
import org.junit.Test

import org.junit.Assert.*

class LC206Test {

    @Test
    fun reverseList() {
        val listNode = ListNode(intArrayOf(1, 2, 3, 4, 5))
        val reverseList = LC206().reverseList(listNode)
        println(reverseList)
    }

    @Test
    fun reverseList1() {
        val listNode = ListNode(intArrayOf(1, 2, 3, 4, 5))
        val reverseList = LC206().reverseList1(listNode)
        println(reverseList)
    }
}