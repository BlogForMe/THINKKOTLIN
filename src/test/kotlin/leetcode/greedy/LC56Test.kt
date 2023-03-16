package leetcode.greedy

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import printDimensionalArray

class LC56Test {

    @Test
    fun merge() {
//        LC56().merge(
//            arrayOf(
//                intArrayOf(1, 3),
//                intArrayOf(2, 6),
//                intArrayOf(8, 10),
//                intArrayOf(15, 18),
//            )
//        ).printDimensionalArray()

        LC56().merge(
            arrayOf(
                intArrayOf(1,4),
                intArrayOf(2,3),
            )
        ).printDimensionalArray()

//        LC56().merge(
//            arrayOf(
//                intArrayOf(1, 4),
//                intArrayOf(4, 5),
//            )
//        ).printDimensionalArray()
    }
}