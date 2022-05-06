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
    }

    @Test
    fun get() {

    }

    @Test
    fun addAtHead() {

        assertEquals(2,linkedList.get(1))
        assertEquals(1,linkedList.get(2))
    }

    @Test
    fun addAtTail() {

    }

    @Test
    fun addAtIndex() {
        linkedList

    }

    @Test
    fun deleteAtIndex() {
    }
}