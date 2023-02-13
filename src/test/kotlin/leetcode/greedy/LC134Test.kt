package leetcode.greedy

import org.junit.Assert
import org.junit.Test


class LC134Test {

    @Test
    fun canCompleteCircuit() {
        Assert.assertEquals(3, LC134().canCompleteCircuit(intArrayOf(1, 2, 3, 4, 5), intArrayOf(3, 4, 5, 1, 2)))
//        Assert.assertEquals(3, LC134().canCompleteCircuit(intArrayOf(2, 3, 4), intArrayOf(3, 4, 3)))
    }
}