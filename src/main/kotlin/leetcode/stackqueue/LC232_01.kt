package leetcode.stackqueue

import java.util.*

/**
 * https://leetcode.cn/problems/implement-queue-using-stacks/solution/wen-zi-shi-pin-de-fang-shi-xiang-xi-jiang-jie-li-2/
 *
 * 在LC232基础上进行的优化，之前每次pop后，还得把元素放回去,这里只有push判断 tempStack有没有元素
 */
class LC232_01 {

    val stackIn = Stack<Int>() // 元素栈
    val tempStack = Stack<Int>()  // 备用

    fun push(x: Int) {
        while (!tempStack.empty()){ //
            stackIn.push(tempStack.pop())
        }
        stackIn.push(x)
    }

    fun pop(): Int {
        while (!stackIn.empty()) {
            tempStack.push(stackIn.pop())
        }
        var pop = -1 // 需要-1
        if (!tempStack.isEmpty()) {
            pop = tempStack.pop() // 这里取的就是头元素
        }
        return pop
    }

    fun peek(): Int {
        val pop = this.pop()
        stackIn.push(pop) // 复用pop，拿出来 再放回去
        return pop
    }

    fun empty(): Boolean {
        return tempStack.empty()&&stackIn.empty()
    }
}

