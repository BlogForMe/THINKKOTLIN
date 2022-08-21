package leetcode.tree

import leetcode.ext.ConstructTree
import org.junit.Assert
import org.junit.Test

class LC94Test {

    @Test
    fun inorderTraversal() {
        val constructTree = ConstructTree.constructTree(arrayOf(1, null, 2, 3))
        val preorderTraversal = LC94().inorderTraversal(constructTree).toIntArray()
        Assert.assertArrayEquals(intArrayOf(1, 3, 2), preorderTraversal)
    }

    @Test
    fun inorderTraversal1() {
        val constructTree = ConstructTree.constructTree(arrayOf(1, null, 2, 3))
        val preorderTraversal = LC94().inorderTraversal1(constructTree).toIntArray()
        Assert.assertArrayEquals(intArrayOf(1, 3, 2), preorderTraversal)
    }
}