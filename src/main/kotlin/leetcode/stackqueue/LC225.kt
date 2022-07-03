package leetcode.stackqueue

import java.util.*

class LC225 {
    private val mainDeque = ArrayDeque<Int>()
    private val tempDeque = ArrayDeque<Int>()


    fun push(x: Int) {
        while (!tempDeque.isEmpty()) {
            mainDeque.offerLast(tempDeque.poll())
        }
        mainDeque.offerLast(x)
    }

    fun pop(): Int {
        var data = -1
        while (!mainDeque.isEmpty()) {
            if (mainDeque.size == 1) {
                data = mainDeque.poll()
            } else {
                data = mainDeque.poll()
                tempDeque.offerLast(data)
            }
        }
        while (!tempDeque.isEmpty()) {
            mainDeque.offerLast(tempDeque.poll())
        }
        return data
    }

    fun top(): Int {
        val pop = this.pop()
        mainDeque.offerLast(pop)
        return pop
    }

    fun empty(): Boolean {
        return tempDeque.isEmpty() && mainDeque.isEmpty()
    }
}
