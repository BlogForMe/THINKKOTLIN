package leetcode.tree

import leetcode.ext.TreeOperation
import org.junit.Assert
import org.junit.Test


class LC654Test {

    val array = intArrayOf(3, 2, 1, 6, 0, 5)

    @Test
    fun constructMaximumBinaryTree() {
        val constructMaximumBinaryTree = LC654().constructMaximumBinaryTree(array)
        println(constructMaximumBinaryTree)
        TreeOperation.show(constructMaximumBinaryTree)

        val constructMaximumBinaryTree1 = LC654().constructMaximumBinaryTree(intArrayOf(3, 2, 1))
        TreeOperation.show(constructMaximumBinaryTree1)
    }

    @Test
    fun getMaxIndex() {
        Assert.assertEquals(3, LC654().getMaxIndex(array, 0, array.size - 1))
        Assert.assertEquals(3, LC654().getMaxIndex(array, 0, 3))
        Assert.assertEquals(1, LC654().getMaxIndex(array, 1, 2))
    }
}