import leetcode.greedy.LC435
import org.junit.Assert
import org.junit.jupiter.api.Test


class LC435Test {

    @Test
    fun eraseOverlapIntervals() {
            LC435().eraseOverlapIntervals(
                arrayOf(
                    intArrayOf(10, 16),
                    intArrayOf(2, 8),
                    intArrayOf(1, 6),
                    intArrayOf(7, 12)
                )
            )
    }
}