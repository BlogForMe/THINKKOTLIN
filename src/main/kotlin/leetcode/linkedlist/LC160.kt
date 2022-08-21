package leetcode.linkedlist

import leetcode.ext.ListNode

class LC160 {
    fun getIntersectionNode(headA: ListNode?, headB: ListNode?): ListNode? {
        var pA = headA
        var pB = headB
        if (pA == null || pB == null) {
            return null
        }
        while (pA != pB) { // 相互第2个连接的链表走完后，下个节点都是null 循环就结束了
            pA = if (pA == null) {
                headB
            } else {
                pA.next
            }

            pB = if (pB == null) {
                headA
            } else {
                pB.next
            }
        }
        return pA
    }
}