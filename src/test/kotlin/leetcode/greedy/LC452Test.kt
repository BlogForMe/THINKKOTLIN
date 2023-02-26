package leetcode.greedy

import leetcode.TestLinkeList
import org.junit.Assert
import org.junit.Test

class LC452Test {

    @Test
    fun findMinArrowShots() {
//        Assert.assertEquals(
//            2,
//            LC452().findMinArrowShots(
//                arrayOf(
//                    intArrayOf(10, 16),
//                    intArrayOf(2, 8),
//                    intArrayOf(1, 6),
//                    intArrayOf(7, 12)
//                )
//            )
//        )
//        Assert.assertEquals(
//            2,
//            LC452().findMinArrowShots(
//                arrayOf(
//                    intArrayOf(-2147483646, -2147483645),
//                    intArrayOf(2147483646, 2147483647),
//                )
//            )
//        )


        Assert.assertEquals(
            2,
            LC452().findMinArrowShots(
                arrayOf(
                    intArrayOf(3, 9),
                    intArrayOf(7, 12),
                    intArrayOf(3, 8),
                    intArrayOf(6, 8),
                    intArrayOf(9, 10),
                    intArrayOf(2, 9),
                    intArrayOf(9, 10),
                    intArrayOf(0, 9),
                    intArrayOf(3, 9),
                    intArrayOf(0, 6),
                    intArrayOf(2, 8),
                )
            )
        )

    }

    @Test
    fun tmyr() {

        val findMinArrowShots = TestLinkeList().findMinArrowShots(
            arrayOf(
                intArrayOf(3, 9),
                intArrayOf(7, 12),
                intArrayOf(3, 8),
                intArrayOf(6, 8),
                intArrayOf(9, 10),
                intArrayOf(2, 9),
                intArrayOf(9, 10),
                intArrayOf(0, 9),
                intArrayOf(3, 9),
                intArrayOf(0, 6),
                intArrayOf(2, 8),
            )
        )
        println(findMinArrowShots)
    }

}