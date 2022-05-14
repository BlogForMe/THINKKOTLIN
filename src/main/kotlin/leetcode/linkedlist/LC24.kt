package leetcode.linkedlist

import leetcode.tool.ListNode

class LC24 {
    fun swapPairs(head: ListNode?): ListNode? {
        val dumpNode = ListNode()
        dumpNode.next = head
        var temp = dumpNode
        while (temp.next?.next != null) {
            val n1 = temp.next
            val n2 = n1?.next
            n1?.next = n2?.next
            temp.next = n2
            n2?.next = n1
            temp = n1!!
        }
        return dumpNode.next
    }
}