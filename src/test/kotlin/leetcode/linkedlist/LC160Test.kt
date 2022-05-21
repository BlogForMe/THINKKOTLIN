package leetcode.linkedlist

import leetcode.tool.ListNode
import org.junit.Test

class LC160Test {

    @Test
    fun getIntersectionNode() {
        //这里因为ListNode(intArrayOf(4, 1, 8, 4, 5)),
        //            ListNode(intArrayOf(5, 0, 1, 8, 4, 5))
        //生成的节点指针是分开的，所以ide测试用例不一样，leetcode没问题的
        val intersectionNode1 = LC160().getIntersectionNode(
            ListNode(intArrayOf(4, 1, 8, 4, 5)),
            ListNode(intArrayOf(5, 0, 1, 8, 4, 5))
        )
        println(intersectionNode1)

//        val intersectionNode =
//            LC160().getIntersectionNode(ListNode(intArrayOf(2, 6, 4)), ListNode(intArrayOf(1, 5)))
//        println(intersectionNode)
    }
}