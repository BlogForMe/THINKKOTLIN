package leetcode.tree

import leetcode.ext.ConstructTree
import org.junit.Assert
import org.junit.Test


class LC145Test {

    @Test
    fun postorderTraversal() {
        val constructTree = ConstructTree.constructTree(arrayOf(1, null, 2, 3))
        val preorderTraversal = LC145().postorderTraversal(constructTree).toIntArray()
        Assert.assertArrayEquals(intArrayOf(3, 2, 1), preorderTraversal)
    }
}