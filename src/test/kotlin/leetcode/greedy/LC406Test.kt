package leetcode.greedy

import TestLinkeList
import org.junit.Test
import printDimensionalArray
import java.util.*

class LC406Test {

    @Test
    fun reconstructQueueTest() {
//        val reconstructQueue = LC406().reconstructQueue(
//            arrayOf(
//                intArrayOf(7, 0),
//                intArrayOf(4, 4),
//                intArrayOf(7, 1),
//                intArrayOf(5, 0),
//                intArrayOf(6, 1),
//                intArrayOf(5, 2)
//            )
//        )
        val reconstructQueue1 = LC406().reconstructQueue(
            arrayOf(
                intArrayOf(6, 0),
                intArrayOf(5, 0),
                intArrayOf(4, 0),
                intArrayOf(3, 2),
                intArrayOf(2, 2),
                intArrayOf(1, 4)
            )
        )

//        TestLinkeList.reconstructQueue(reconstructQueue1)
//        reconstructQueue.printDimensionalArray()
        reconstructQueue1.printDimensionalArray()
    }

    @Test
    fun LinkedListTest(){
        val linkedList = LinkedList<Int>()
        linkedList.add(0,0)
        linkedList.add(2,2)

        val que = LinkedList<IntArray>()

    }
}