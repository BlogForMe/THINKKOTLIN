package leetcode.array

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test


internal class LC977Test {

    @Test
    fun sortedSquares() {
        assertThat(intArrayOf(0,1,9,16,100),equalTo(LC977().sortedSquares(intArrayOf(-4, -1, 0, 3, 10))))
    }
}