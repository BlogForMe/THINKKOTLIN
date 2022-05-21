package leetcode.linkedlist

import leetcode.tool.ListNode
import org.junit.Test

import org.junit.Assert.*

class LC142Test {

    @Test
    fun detectCycle() {
       """
          [1]
          -1 
          
          [1,2]
          -1
          
        [3,2,0,-4]
        1
        
        [1,2]
        0
       """.trimIndent()
//        val detectCycle = LC142().detectCycle(ListNode(intArrayOf(1,2)))
//        val detectCycle = LC142().detectCycle(ListNode(intArrayOf(1,2)))
        val detectCycle = LC142().detectCycle(ListNode(intArrayOf(1)))
        println(detectCycle)
    }


    @Test
    fun detectCycle2() {
        val detectCycle = LC142_02().detectCycle(ListNode(intArrayOf(1)))
        println(detectCycle)

        val intArrayOf = intArrayOf(3, 6)
        println(intArrayOf)
        val arrayOf = arrayOf(3, 6)
        println(arrayOf)

    }

}
