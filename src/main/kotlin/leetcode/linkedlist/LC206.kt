package leetcode.linkedlist

import leetcode.tool.ListNode

class LC206 {
    fun reverseList(head: ListNode?): ListNode? {
        var pre = head
        var curr: ListNode? = null
        while (pre != null) {
            val termPre = pre.next
            pre.next = curr
            curr = pre
            if (termPre == null) { // 到了最后一个note下一个note,不能赋值了，否则pre就是null作为头节点了
                return pre
            }
            pre = termPre
        }
        return pre // 最后一个node,指向前面的node
    }


    fun reverseList1(head: ListNode?): ListNode? {
        var pre = head
        var curr: ListNode? = null
        while (pre != null) {
            val termPre = pre.next
            pre.next = curr
            curr = pre
            pre = termPre
        }
        return curr // 最后一个node not null,指向前面的node
    }
}
