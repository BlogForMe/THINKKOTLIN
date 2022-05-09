package leetcode.linkedlist

import leetcode.tool.ListNode


class MyLinkedList() {
    val dummyHead = ListNode()

    fun get(index: Int): Int {
        var pIndex = index
        var p = dummyHead.next
        while (pIndex-- > 0) {
            p = p?.next
        }
        return p?.`val` ?: 0
    }

    fun addAtHead(`val`: Int) {
        val newNode = ListNode(`val`) // 新的节点
        val headNode = dummyHead.next // 之前的头节点
        dummyHead.next = newNode  // 虚拟头节点 指向新的头节点
        if (headNode != null) {
            newNode.next = headNode // 新的头节点指向 之前的头节点
        }
    }

    fun addAtTail(`val`: Int) {
        val newNode = ListNode(`val`) // 新的节点
        var p: ListNode? = dummyHead.next
        while (p != null) {
            if (p.next == null) {
                p.next = newNode
                break // 必须停止，否则一直在尾部添加 新的节点
            }
            p = p.next
        }
    }

    fun addAtIndex(index: Int, `val`: Int) {
        val newNode = ListNode(`val`) // 新的节点
        var pIndex = index
        var p = dummyHead.next
        while (pIndex-- > 0) {
            p = p?.next
        }
        if (p != null) {
            p.next = newNode
        }
    }

    fun deleteAtIndex(index: Int) {

    }

}