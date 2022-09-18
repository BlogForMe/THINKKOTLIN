package leetcode.tree

import leetcode.ext.ConstructTree.constructTree
import leetcode.ext.TreeOperation
import org.junit.Assert
import org.junit.Test

class LC110Test {

    @Test
    fun isBalanced() {
        TreeOperation.show(constructTree(arrayOf(1, 2, 2, 3, null, null, 3, 4, null, null, 4)))

        Assert.assertEquals(true, LC110().isBalanced(constructTree(arrayOf(3, 9, 20, null, null, 15, 7))))
        Assert.assertEquals(
            false,
            LC110().isBalanced(constructTree(arrayOf(1, 2, 2, 3, null, null, 3, 4, null, null, 4)))
        )
    }
}