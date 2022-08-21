package leetcode.linkedlist

import leetcode.ext.ListNode


class MyLinkedList() {
    private val dummyHead = ListNode()
    var size = 0 //length

    fun get(index: Int): Int {
        if (index < -1 || index > size - 1) return -1 // 2.注意这里之前是 index >= size
        var pIndex = index
        var curr = dummyHead.next
        while (pIndex-- > 0) {
            curr = curr?.next
        }
        return curr?.`val` ?: -1
    }

    fun addAtHead(`val`: Int) {
        val newNode = ListNode(`val`) // 新的节点
        val headNode = dummyHead.next // 之前的头节点
        dummyHead.next = newNode  // 虚拟头节点 指向新的头节点
        if (headNode != null) {
            newNode.next = headNode // 新的头节点指向 之前的头节点
        }
        size++  // 注意： 之前这个放在上边的if里面
    }

    fun addAtTail(`val`: Int) {
        val newNode = ListNode(`val`) // 新的节点
        var p: ListNode? = dummyHead // 1.注意这里不是dummyHead.next
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
        if (index > size) return  //2. 注意这里之前是 index >= size
        val newNode = ListNode(`val`) // 新的节点
        var pIndex = index
        var curr = dummyHead  // 1.注意这里不是dummyHead.next
        while (pIndex-- > 0) {
            curr = curr.next!!
        }
        val temp = curr.next
        curr.next = newNode
        newNode.next = temp
        size++
    }

    fun deleteAtIndex(index: Int) {
        if (index >= size || index < 0) {
            return
        }
        var pIndex = index
        var curr: ListNode? = dummyHead //1. 注意这里之前是 index >= size
        while (pIndex-- > 0) {
            curr = curr?.next
        }
        if (curr?.next != null) {
            curr.next = curr.next?.next
        }
        size--   // 注意： 之前这个放在上边的if里面
    }
}