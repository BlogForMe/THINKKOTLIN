package leetcode.array

import org.junit.Test


internal class LC209Test {

    @Test
    fun minSubArrayLen() {
        assert(2 == LC209().minSubArrayLen(7, intArrayOf(2, 3, 1, 2, 4, 3)))
        assert(1 == LC209().minSubArrayLen(4, intArrayOf(1,4,4)))
        assert(0 == LC209().minSubArrayLen(11, intArrayOf(1,1,1,1,1,1,1,1)))
    }
}