package leetcode.linkedlist

import leetcode.tool.ListNode

class LC142 {
    fun detectCycle(head: ListNode?): ListNode? {
//        val dumpNode: ListNode? = ListNode() // 不设置的话，如果有指针next是null,赋值就有问题,这个不能有，必须从head出发的,因为fast point走两部
        var fp = head
        var sp = head
        while (true) {
            fp = fp?.next?.next
            sp = sp?.next
            if (fp == null) {
                return null // 走到底了，no cycle, 需要放前面，否则都是null的话，下面的fp == sp条件就匹配了
            } else if (fp == sp) {
                break
            }
        }
        var secondPoint = head
        while (sp?.next != null && secondPoint != sp) {
            secondPoint = secondPoint?.next!!
            sp = sp.next
        }
        return secondPoint
    }
}