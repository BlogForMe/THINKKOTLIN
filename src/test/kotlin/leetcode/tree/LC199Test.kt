package leetcode.tree

import leetcode.ext.ConstructTree
import org.junit.Assert
import org.junit.Test

class LC199Test {

    @Test
    fun rightSideView() {
        val constructTree = ConstructTree.constructTree(arrayOf(1, 2, 3, null, 5, null, 4))
        Assert.assertArrayEquals(intArrayOf(1, 3, 4), LC199().rightSideView(constructTree).toIntArray())

    }
}