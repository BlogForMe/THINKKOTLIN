package leetcode.linkedlist

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class LC707MyLinkedListTest {
    val linkedList = MyLinkedList();


    @Before
    fun setUp() {
        linkedList.addAtHead(1)
        linkedList.addAtHead(2)
        linkedList.addAtHead(3)
        linkedList.addAtHead(4)
    }

    @Test
    fun get() {
        val get = linkedList.get(1)
    }

    @Test
    fun addAtHead() {
        assertEquals(2,linkedList.get(1))
        assertEquals(1,linkedList.get(2))
    }

    @Test
    fun addAtTail() {
        linkedList.addAtTail(8)
    }

    @Test
    fun addAtIndex() {
        linkedList.addAtIndex(1,99)
        linkedList.addAtIndex(-5,-5)
        println(linkedList)
    }

    @Test
    fun deleteAtIndex() {
        linkedList.deleteAtIndex(1)
        println(linkedList)
    }
}