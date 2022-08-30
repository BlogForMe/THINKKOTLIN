package leetcode.tree

import leetcode.ext.ConstructTree.constructTree
import org.junit.Assert
import org.junit.Test

class LC144Test {

    @Test
    fun preorderTraversal() {
        val constructTree = constructTree(arrayOf(1, null, 2, 3))
        val preorderTraversal = LC144().preorderTraversal(constructTree).toIntArray()
        Assert.assertArrayEquals(intArrayOf(1, 2, 3), preorderTraversal)

        Assert.assertArrayEquals(intArrayOf(1, 2), LC144().preorderTraversal(constructTree(arrayOf(1, 2))).toIntArray())

    }


    @Test
    fun preorderTraversal1() {
        val constructTree = constructTree(arrayOf(1, null, 2, 3))
        Assert.assertArrayEquals(intArrayOf(1, 2, 3), LC144().preorderTraversal1(constructTree).toIntArray())



    }

}