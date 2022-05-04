package leetcode.array

import org.junit.Test


class LC904Test {

    @Test
    fun totalFruit() {

//        assert(LC904().totalFruit(intArrayOf(1, 2, 1)) == 3)
//        assert(LC904().totalFruit(intArrayOf(0, 1, 2, 2)) == 3)
//        assert(LC904().totalFruit(intArrayOf(1, 2, 3, 2, 2)) == 4)
//        assert(LC904().totalFruit(intArrayOf(3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4)) == 5)
//        assert(LC904().totalFruit(intArrayOf(3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4)) == 5)

        assert(LC904().totalFruit1(intArrayOf(1, 2, 1)) == 3)
        assert(LC904().totalFruit1(intArrayOf(0, 1, 2, 2)) == 3)
        assert(LC904().totalFruit1(intArrayOf(1, 2, 3, 2, 2)) == 4)
        assert(LC904().totalFruit1(intArrayOf(3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4)) == 5)
        assert(LC904().totalFruit1(intArrayOf(3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4)) == 5)

    }
}