package leetcode.stackqueue

import java.util.*

/**
 * https://programmercarl.com/0225.%E7%94%A8%E9%98%9F%E5%88%97%E5%AE%9E%E7%8E%B0%E6%A0%88.html
 * https://leetcode.cn/problems/implement-stack-using-queues/solution/yong-dui-lie-shi-xian-zhan-by-leetcode-solution/
 */
class LC225_01 {
    private var mainDeque = LinkedList<Int>()
    private var tempDeque = LinkedList<Int>()


    fun push(x: Int) {
        tempDeque.offer(x)
        while (!mainDeque.isEmpty()) {
            tempDeque.offerLast(mainDeque.poll())
        }

        val temp = mainDeque //此时mainDeque一定是空的,不过没关系，不用再创建一个
        mainDeque = tempDeque //交换队列元素, tempDeque的元素给mainDeque
        tempDeque = temp
    }

    fun pop(): Int {
        return mainDeque.poll() //删除并返回元素
    }

    fun top(): Int {
        return mainDeque.peek() // 返回元素
    }

    fun empty(): Boolean {
        return tempDeque.isEmpty() && mainDeque.isEmpty()
    }
}
