package leetcode.linkedlist

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class LC707MyLinkedListTest {
    val linkedList = MyLinkedList();


    @Test
    fun get() {
        val get = linkedList.get(1)
    }

    @Test
    fun addAtHead() {
        assertEquals(2, linkedList.get(1))
        assertEquals(1, linkedList.get(2))
    }

    @Test
    fun addAtTail() {
        linkedList.addAtTail(8)
    }

    @Test
    fun addAtIndex() {
        linkedList.addAtIndex(1, 99)
        linkedList.addAtIndex(-5, -5)
        println(linkedList)
    }

    @Test
    fun deleteAtIndex() {
        linkedList.deleteAtIndex(1)
        println(linkedList)
    }

//    ["MyLinkedList","addAtHead","addAtTail","addAtIndex","get","deleteAtIndex","get"]
//    [[],[1],[3],[1,2],[1],[1],[1]]
//    [null,null,null,null,2,null,3]
    @Test
    fun testCase1() {
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
        val get = linkedList.get(1);            //返回2
        linkedList.deleteAtIndex(1);  //现在链表是1-> 3
        val get1 = linkedList.get(1);            //返回3

        println(linkedList)
    }

    //["MyLinkedList","addAtHead","addAtHead","addAtHead","addAtIndex","deleteAtIndex","addAtHead","addAtTail","get","addAtHead","addAtIndex","addAtHead"]
    //[[],[7],[2],[1],[3,0],[2],[6],[4],[4],[4],[5,0],[6]]

    //[null,null,null,null,null,null,null,null,-1,null,null,null] actual
    //[null,null,null,null,null,null,null,null,4,null,null,null]

    @Test
    fun testCase2(){
        linkedList.addAtHead(7);
        linkedList.addAtHead(2);
        linkedList.addAtHead(1);
        linkedList.addAtIndex(3,0)
        linkedList.deleteAtIndex(2)
        linkedList.addAtHead(6)
        linkedList.addAtTail(4)
        val get = linkedList.get(4)
        linkedList.addAtHead(4)
        linkedList.addAtIndex(5,0)
        linkedList.addAtHead(6)

        println(linkedList)
    }


    // ["MyLinkedList","addAtTail","get"]
    // [null,null,-1]
    // [null,null,1]

    @Test
    fun  testCase3(){
        linkedList.addAtTail(1)
        val get = linkedList.get(0)
        println(linkedList)
    }


}