package leetcode.linkedlist

import leetcode.tool.ListNode


class MyLinkedList() {
    private val dummyHead = ListNode()
    var size = 0 //length

    fun get(index: Int): Int {
        if (index < -1 || index >= size) return -1
        var pIndex = index
        var p = dummyHead.next
        while (pIndex-- > 0) {
            p = p?.next
        }
        return p?.`val` ?: -1
    }

    fun addAtHead(`val`: Int) {
        val newNode = ListNode(`val`) // 新的节点
        val headNode = dummyHead.next // 之前的头节点
        dummyHead.next = newNode  // 虚拟头节点 指向新的头节点
        if (headNode != null) {
            newNode.next = headNode // 新的头节点指向 之前的头节点
            size++
        }
    }

    fun addAtTail(`val`: Int) {
        val newNode = ListNode(`val`) // 新的节点
        var p: ListNode? = dummyHead.next
        while (p != null) {
            if (p.next == null) {
                p.next = newNode
                size++
                break // 必须停止，否则一直在尾部添加 新的节点
            }
            p = p.next
        }
    }

    fun addAtIndex(index: Int, `val`: Int) {
        if (index < 0) {
            addAtHead(`val`)
            size++
            return
        }
        if (index >= size) return
        val newNode = ListNode(`val`) // 新的节点
        var pIndex = index
        var curr = dummyHead.next
        while (pIndex-- > 0) {
            curr = curr?.next
        }
        val temp = curr?.next
        if (curr != null) {
            curr.next = newNode
            newNode.next = temp
            size++
        }
    }

    fun deleteAtIndex(index: Int) {
        var pIndex = index
        var curr: ListNode? = dummyHead
        while (pIndex-- > 0) {
            curr = curr?.next
        }
        if (curr?.next != null) {
            curr.next = curr.next?.next
            size--
        }
    }
}