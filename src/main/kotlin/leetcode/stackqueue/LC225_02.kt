package leetcode.stackqueue

import java.util.*

class LC225_02 {
    private var mainDeque = LinkedList<Int>()

    fun push(x: Int) {
        mainDeque.offer(x)
        for (i in 0 until mainDeque.size - 1) { // 注意这里要-1,这样最后入队的就在头部.否则就没有意义了
            mainDeque.offer(mainDeque.poll())
        }
    }

    fun pop(): Int {
        return mainDeque.poll() //删除并返回元素
    }

    fun top(): Int {
        return mainDeque.peek() // 返回元素
    }

    fun empty(): Boolean {
        return mainDeque.isEmpty()
    }
}


fun main() {
    val queue = LinkedList<Int>()
    queue.offer(0)
    queue.offer(1)
    queue.offer(2)

    queue.offer(3)
    for (i in 0 until queue.size - 1) {
        queue.offer(queue.poll())
        println(queue)
    }

    //看到这个入队结果
    // [1, 2, 3, 0]
    //[2, 3, 0, 1]
    //[3, 0, 1, 2]

}