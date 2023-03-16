import leetcode.greedy.LC435
import leetcode.greedy.LC452
import org.junit.Assert
import org.junit.jupiter.api.Test


class LC435Test {

    @Test
    fun eraseOverlapIntervals() {
//        Assert.assertEquals(
//            1, LC435().eraseOverlapIntervals(
//                arrayOf(
//                    intArrayOf(1, 2),
//                    intArrayOf(1, 3),
//                    intArrayOf(2, 3),
//                    intArrayOf(3, 4)
//                )
//            )
//        )

//        println()
        LC435().eraseOverlapIntervals(
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
    }
}