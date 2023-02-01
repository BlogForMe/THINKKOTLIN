package leetcode.greedy

import org.junit.Assert
import org.junit.Test
import senior.easyPrint
import java.util.*


class LC1005Test {

    @Test
    fun largestSumAfterKNegations() {
        Assert.assertEquals(5, LC1005().largestSumAfterKNegations(intArrayOf(4, 2, 3), 1))
        Assert.assertEquals(13, LC1005().largestSumAfterKNegations(intArrayOf(2, -3, -1, 5, -4), 2))
        Assert.assertEquals(5, LC1005().largestSumAfterKNegations(intArrayOf(-4, -2, -3), 4))
    }


    @Test
    fun absSortTest() {
        val array = arrayOf(2, -3, -1, 5, -4)
        Arrays.sort(array, Comparator.comparingInt(Math::abs))
        array.easyPrint()
    }
}