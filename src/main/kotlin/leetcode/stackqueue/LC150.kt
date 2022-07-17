package leetcode.stackqueue

import java.util.Stack

class LC150 {
    fun evalRPN(tokens: Array<String>): Int {
        val stack = Stack<Int>()
        tokens.forEach {
            if (it == "+" || it == "-" || it == "*" || it == "/") {
                val pop1 = stack.takeUnless { p1 -> p1.empty() }?.pop()
                val pop2 = stack.takeUnless { p2 -> p2.empty() }?.pop()
                if (pop1 != null && pop2 != null) {
                    val result = getResult(it, pop2.toInt(), pop1.toInt()) // stack取的第二个数放前面
                    stack.push(result)
                }
            } else {
                stack.push(it.toInt())
            }
        }
        return stack.peek()
    }

    private fun getResult(operator: String, pop1: Int, pop2: Int): Int {
        return when (operator) {
            "+" -> pop1 + pop2
            "-" -> pop1 - pop2
            "*" -> pop1 * pop2
            "/" -> pop1 / pop2
            else -> throw RuntimeException("oh something went wrong")
        }
    }

}