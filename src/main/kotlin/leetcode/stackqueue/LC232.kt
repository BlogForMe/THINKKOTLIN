package leetcode.stackqueue

import java.util.*

class LC232 {

    val stack = Stack<Int>() // 元素栈
    val tempStack = Stack<Int>()  // 备用

    fun push(x: Int) {
        stack.push(x)
    }

    fun pop(): Int {
        while (!stack.empty()) {
            tempStack.push(stack.pop())
        }
        var pop = 0
        if (!tempStack.isEmpty()) {
            pop = tempStack.pop() // 这里取的就是头元素
        }
        while (!tempStack.empty()) {
            stack.push(tempStack.pop())
        }
        return pop
    }

    fun peek(): Int {
        while (!stack.empty()) {
            tempStack.push(stack.pop())
        }
        var peek = 0
        if (!tempStack.isEmpty()) {
            peek = tempStack.peek() // 这里取的就是头元素,不会删除
        }
        while (!tempStack.empty()) {
            stack.push(tempStack.pop())
        }
        return peek
    }

    fun empty(): Boolean {
        return stack.empty()
    }
}

