package leetcode.greedy

import java.util.*


class LC406 {
    fun reconstructQueue(people: Array<IntArray>): Array<IntArray> {
        Arrays.sort(people, object : Comparator<IntArray> {
            override fun compare(o1: IntArray, o2: IntArray): Int {
                if (o2[0] == o1[0]) {       // 如果身高相同，k小的排在前面
                    return o1[1] - o2[1]
                }
                return o2[0] - o1[0]        // 对数组先按照身高来排序
            }
        })
        val linkedList = LinkedList<IntArray>()

        for (value in people){
            val index = value[1]
            linkedList.add(index,value) // 按照k插入对应的位置
        }

        return linkedList.toTypedArray()
    }
}