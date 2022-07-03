package leetcode.stackqueue

import java.util.*

/**
 * https://programmercarl.com/0232.%E7%94%A8%E6%A0%88%E5%AE%9E%E7%8E%B0%E9%98%9F%E5%88%97.html#%E5%85%B6%E4%BB%96%E8%AF%AD%E8%A8%80%E7%89%88%E6%9C%AC
 *
 * 随想录写法
 * 在LC232_01基础上进行的优化，push的时候不用每次都判断，只有stackOut是空的时候，才需要取后面的元素
 */
class LC232_02 {

    private val stackIn = Stack<Int>() // 输入栈
    private val stackOut = Stack<Int>()  // 输出栈

    fun push(x: Int) {
        stackIn.push(x)
    }

    fun pop(): Int {
        if (stackOut.isEmpty()) {
            while (!stackIn.empty()) {
                stackOut.push(stackIn.pop())
            }
        }
        var data = -1
        if (!stackOut.isEmpty()) {
            data = stackOut.pop()
        }
        return data
    }

    fun peek(): Int {
        val pop = this.pop()
        stackOut.push(pop) // 复用pop，拿出来 再放回去
        return pop
    }

    fun empty(): Boolean {
        return stackOut.empty() && stackIn.empty()
    }
}

