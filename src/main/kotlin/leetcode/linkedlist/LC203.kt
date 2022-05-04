package leetcode.linkedlist

import leetcode.tool.ListNode

class LC203 {
    fun removeElements(head: ListNode?, target: Int): ListNode? {
        var topPoint = ListNode(head)
        var p = topPoint
        while (p.next != null) {
            p = p.next!!
//            if (p.element == 6) {
//            }
            print(" ${p.element} ")
        }
        return p
    }
}