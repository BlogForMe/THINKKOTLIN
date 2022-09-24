package leetcode.tree

import leetcode.ext.ConstructTree
import leetcode.ext.TreeNode
import leetcode.ext.TreeOperation
import org.junit.Assert
import org.junit.Test


class LC404Test {

    @Test
    fun sumOfLeftLeaves() {
        Assert.assertEquals(
            24,
            LC404().sumOfLeftLeaves(ConstructTree.constructTree(arrayOf(3, 9, 20, null, null, 15, 7)))
        )
        Assert.assertEquals(
            0,
            LC404().sumOfLeftLeaves(ConstructTree.constructTree(arrayOf(1)))
        )
        TreeOperation.show(ConstructTree.constructTree(arrayOf(1, 2, 3, 4, 5)))

        Assert.assertEquals(
            4,
            LC404().sumOfLeftLeaves(ConstructTree.constructTree(arrayOf(1, 2, 3, 4, 5)))
        )
    }
}