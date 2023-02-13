package leetcode.greedy

import org.junit.Assert
import org.junit.Test

class LC135Test {

    @Test
    fun candy() {
//        Assert.assertEquals(5, LC135().candy(intArrayOf(1, 0, 2)))
//        Assert.assertEquals(11, LC135().candy(intArrayOf(1, 3, 4, 5, 2)))
        Assert.assertEquals(4, LC135().candy(intArrayOf(1, 2, 2)))
    }
}