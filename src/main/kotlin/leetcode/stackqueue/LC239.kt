package leetcode.stackqueue

import java.util.*

class LC239 {
    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        val linkedList = LinkedList<Int>()
        val resultArray = IntArray(nums.size - (k - 1))  // 如果窗口是3个元素，结构数组就需要少两个元素
        var i = 0
        nums.forEachIndexed { index, value ->
            if (index > (k - 1) && nums[index - k] == linkedList.peek()) { // nums[index - k]是队列头部最大元素，此时最大元素出队列,因为最大元素一定改窗口的最左侧元素
                linkedList.pop()                                           // 如果不是最大元素，因为滑动窗口可能没有k个元素,也不用担心是不是留在窗口里，这种情况下其实在下面push已经早出去了
            }
            while (!linkedList.isEmpty() && value > linkedList.last()) {   // 如果大于最后一个元素
                linkedList.removeLast()                                     //最后一个元素出队列
            }
            linkedList.offer(value)                                          //否则直接入队,这样保持队列元素单调递减
            if (index >= (k - 1)) { //如果是3个元素，从位置2开始存最大值，如果是1个元素，就从0存最大值
                resultArray[i++] = linkedList.peek()
            }
        }
        return resultArray
    }


    fun maxSlidingWindow1(nums: IntArray, k: Int): IntArray {
        val linkedList = LinkedList<Int>()
        val resultArray = IntArray(nums.size - (k - 1))  // 如果窗口是3个元素，结构数组就需要少两个元素
        var i = 0
        nums.forEachIndexed { index, value ->
            if (index > (k - 1) && index - k == linkedList.peek()) { // 存下标，感觉还是更准确一点,毕竟下标是唯一的
                linkedList.pop()
            }
            while (!linkedList.isEmpty() && value > nums[linkedList.last()]) {   // 如果大于最后一个元素
                linkedList.removeLast()                                     //最后一个元素出队列
            }
            linkedList.offer(index)                                          //否则直接入队,这样保持队列元素单调递减
            if (index >= (k - 1)) { //如果是3个元素，从位置2开始存最大值，如果是1个元素，就从0存最大值
                resultArray[i++] = nums[linkedList.peek()]
            }
        }
        return resultArray
    }

    //随想录
    fun maxSlidingWindow2(nums: IntArray, k: Int): IntArray {
        val linkedList = LinkedList<Int>()
        val resultArray = IntArray(nums.size - (k - 1))  // 如果窗口是3个元素，结构数组就需要少两个元素
        var i = 0
        nums.forEachIndexed { index, value ->
            if (!linkedList.isEmpty() && linkedList.peek() < index - (k - 1)) { //这样更好理解 移动窗口,队列头结点需要在[i - k + 1, i]范围内，不符合则要弹出
                linkedList.pop()
            }
            while (!linkedList.isEmpty() && value > nums[linkedList.last()]) {   // 如果大于最后一个元素
                linkedList.removeLast()                                     //最后一个元素出队列
            }
            linkedList.offer(index)                                          //否则直接入队,这样保持队列元素单调递减
            if (index >= (k - 1)) { //如果是3个元素，从位置2开始存最大值，如果是1个元素，就从0存最大值
                resultArray[i++] = nums[linkedList.peek()]
            }
        }
        return resultArray
    }
}

//if (!linkedList.isEmpty() && value >= linkedList.peek()) { // 1. 如果value比头部的最大元素 大
//    linkedList.clear()                                    // 2. 清理队列
//    linkedList.offer(value)                               // 3. value元素入队
//} else {

fun main() {
    val priorityQueue = PriorityQueue<Int>()
    priorityQueue.offer(2)
    priorityQueue.offer(4)
    priorityQueue.offer(1)
    priorityQueue.offer(3)

    println(priorityQueue)
}