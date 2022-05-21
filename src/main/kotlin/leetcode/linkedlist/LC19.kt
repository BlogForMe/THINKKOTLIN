package leetcode.linkedlist

import leetcode.tool.ListNode

class LC19 {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        val dumpNode = ListNode()
        dumpNode.next = head
        var fp = dumpNode
        var sp = dumpNode
        var lastIndex = n
        while (lastIndex-- > 0) {
            if (fp.next != null) {
                fp = fp.next!!
            }
        }
        while (dumpNode.next != null) {
            if (fp.next == null) { // 必须终止，否则会是死循环
                break
            }
            fp = fp.next!!
            sp = sp.next!!
        }
        sp.next = sp.next?.next
        return dumpNode.next
    }


}

fun main() {
    var index = 2
    while (index-- > 0) {
        println(index)
    }
}