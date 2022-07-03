package leetcode.stackqueue

import junit.framework.TestCase

class LC225Test : TestCase() {
    val lC225 = LC225()


    fun testPush() {
        lC225.push(1)
        lC225.push(2)
        println(lC225)
    }

    fun testPop() {
        val run = lC225.run {
            push(1)
            push(2)
            pop()
        }
        println(run)
    }

    fun testTop() {
        val run = lC225.run {
            push(1)
            push(2)
            pop()
            top()
        }
        println(run)
    }

    fun testEmpty() {}
}