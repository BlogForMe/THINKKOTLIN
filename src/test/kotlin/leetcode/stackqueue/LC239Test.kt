package leetcode.stackqueue

import junit.framework.TestCase
import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert.assertThat

class LC239Test : TestCase() {

    fun testMaxSlidingWindow() {
        assertThat(
            LC239().maxSlidingWindow(intArrayOf(1, 3, -1, -3, 5, 3, 6, 7), 3),
            CoreMatchers.equalTo(intArrayOf(3, 3, 5, 5, 6, 7))
        )
        assertThat(
            LC239().maxSlidingWindow(intArrayOf(1), 1),
            CoreMatchers.equalTo(intArrayOf(1))
        )
        assertThat(
            LC239().maxSlidingWindow(intArrayOf(1, -1), 1),
            CoreMatchers.equalTo(intArrayOf(1, -1))
        )

        assertThat(
            LC239().maxSlidingWindow1(intArrayOf(1, 3, -1, -3, 5, 3, 6, 7), 3),
            CoreMatchers.equalTo(intArrayOf(3, 3, 5, 5, 6, 7))
        )
        assertThat(
            LC239().maxSlidingWindow1(intArrayOf(1), 1),
            CoreMatchers.equalTo(intArrayOf(1))
        )
        assertThat(
            LC239().maxSlidingWindow1(intArrayOf(1, -1), 1),
            CoreMatchers.equalTo(intArrayOf(1, -1))
        )
    }
}