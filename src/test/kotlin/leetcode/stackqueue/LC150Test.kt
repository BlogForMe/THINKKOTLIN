package leetcode.stackqueue

import junit.framework.TestCase

class LC150Test : TestCase() {

    fun testEvalRPN() {
        assertEquals(9,LC150().evalRPN(arrayOf("2","1","+","3","*")))
        assertEquals(6,LC150().evalRPN(arrayOf("4","13","5","/","+")))
        assertEquals(22,LC150().evalRPN(arrayOf("10","6","9","3","+","-11","*","/","*","17","+","5","+")))
    }
}