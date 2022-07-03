package leetcode.stackqueue

import junit.framework.TestCase
import java.util.*

class LC232Test : TestCase() {

    val stack = LC232()

    override fun setUp() {
        stack.push(0)
        stack.push(1)
        stack.push(2)
        stack.push(3)
//        val next = stack.iterator().next()
//        println(next)
    }

    fun testPush() {
        stack.push(0)
        stack.push(1)
        stack.push(2)
        stack.push(3)
        println(stack)
    }

    fun testPop() {
        assertEquals(0, stack.pop())
        assertEquals(1, stack.pop())
        assertEquals(2, stack.pop())
        assertEquals(3, stack.pop())
        assertEquals(0, stack.pop())
    }

    fun testPeek() {
        assertEquals(0, stack.peek())
        assertEquals(0, stack.peek())
        assertEquals(0, stack.pop())
        assertEquals(1, stack.peek())
        assertEquals(1, stack.peek())
    }

    fun testEmpty() {

    }
}