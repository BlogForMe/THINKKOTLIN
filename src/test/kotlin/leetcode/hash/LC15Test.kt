package leetcode.hash

import org.junit.Test

import org.junit.Assert.*

class LC15Test {

    @Test
    fun threeSum() {
        val threeSum = LC15().threeSum(intArrayOf(-1, 0, 1, 2, -1, -4))
        println(threeSum)

        val threeSum2 = LC15().threeSum2(intArrayOf(-1, 0, 1, 2, -1, -4))
        println(threeSum2)

    }
}