package leetcode.tree

import leetcode.ext.ConstructTree
import leetcode.ext.TreeOperation
import org.junit.Test

import org.junit.Assert.*

class LC102Test {

    @Test
    fun levelOrder() {
        val constructTree = ConstructTree.constructTree(arrayOf(3, 9, 20, null, null, 15, 7))
        // 将刚刚创建的树打印出来
        TreeOperation.show(constructTree)

        val levelOrder = LC102().levelOrder(constructTree)
        println(levelOrder)
    }


    @Test
    fun recurrence() {
        val constructTree = ConstructTree.constructTree(arrayOf(3, 9, 20, null, null, 15, 7))
        val levelOrder1 = LC102().levelOrder1(constructTree)
        println(levelOrder1)
    }
}