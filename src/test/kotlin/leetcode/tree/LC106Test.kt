package leetcode.tree

import leetcode.ext.TreeNode
import leetcode.ext.TreeOperation
import org.junit.Assert
import org.junit.Test

class LC106Test {
    val postorder = intArrayOf(9, 15, 7, 20, 3)
    val inorder = intArrayOf(9, 3, 15, 20, 7)

    @Test
    fun buildTree() {
        val buildTree = LC106().buildTree(inorder, postorder)
        println(buildTree)
    }
    @Test
    fun buildTree1() {
        val buildTree = LC106().buildTree1(inorder, postorder)
        println(buildTree)
        TreeOperation.show(buildTree)
    }


    @Test
    fun testCopyOrRange() {
        val inorder = intArrayOf(9, 3, 15, 20, 7)
        val copyOfRange = inorder.copyOfRange(0, 2)
        println(copyOfRange)
    }

    @Test
    fun getIndexNum() {
        Assert.assertEquals(1,LC106().getIndex(TreeNode(3), inorder))
    }
}