package leetcode.tree

import leetcode.ext.TreeOperation
import org.junit.Test

class LC105Test {
    private val preOrder = intArrayOf(3, 9, 20, 15, 7)
    private val inorder = intArrayOf(9, 3, 15, 20, 7)

    @Test
    fun buildTree() {
//        val buildTree = LC105().buildTree(preOrder, inorder)
//        TreeOperation.show(buildTree)

        val buildTree1 = LC105().buildTree1(preOrder, inorder)
        println(buildTree1)
        TreeOperation.show(buildTree1)
    }
}