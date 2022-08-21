package leetcode.linkedlist

import leetcode.ext.ListNode

class LC142_02 {
    fun detectCycle(head: ListNode?): ListNode? {
//        val dumpNode: ListNode? = ListNode() // 1.不设置?的话，如果有指针next是null,赋值就有问题,2.dumpNode这个不能有，必须从head出发的,因为fast point走两部
        var fp = head
        var sp = head
        while (fp != null && sp != null) { // 循环条件盘空就可以了，没有环就一定会走到null, 一直想到条件 fp != sp
            fp = fp.next?.next
            sp = sp.next
            if (fp!=null&&fp == sp) { // fp!=null不加，没环的话，就null==null 了
                var node1 = head
                while (sp?.next != null && node1 != sp) {
                    node1 = node1?.next!!
                    sp = sp.next
                }
                return node1
            }
        }
        return null
    }
}