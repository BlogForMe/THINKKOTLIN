package leetcode.tree

import leetcode.ext.ConstructTree
import leetcode.ext.TreeOperation
import org.junit.Assert
import org.junit.Test


class LC112Test {

    @Test
    fun hasPathSum() {
        Assert.assertEquals(
            true,
            LC112().hasPathSum(ConstructTree.constructTree(arrayOf(5,4,8,11,null,13,4,7,2,null,null,null,1)),22)
        )
        Assert.assertEquals(
            true,
            LC112().hasPathSum(ConstructTree.constructTree(arrayOf(1,2,3)),3)
        )
        Assert.assertEquals(
            false,
            LC112().hasPathSum(ConstructTree.constructTree(arrayOf(1,2,3)),5)
        )
        Assert.assertEquals(
            false,
            LC112().hasPathSum(null,0)
        )
    }

    @Test
    fun hasPathSum1() {
        Assert.assertEquals(
            true,
            LC112().hasPathSum1(ConstructTree.constructTree(arrayOf(5,4,8,11,null,13,4,7,2,null,null,null,1)),22)
        )
        TreeOperation.show(ConstructTree.constructTree(arrayOf(1,2,3)))

        Assert.assertEquals(
            true,
            LC112().hasPathSum1(ConstructTree.constructTree(arrayOf(1,2,3)),3)
        )
        Assert.assertEquals(
            false,
            LC112().hasPathSum1(ConstructTree.constructTree(arrayOf(1,2,3)),5)
        )
        Assert.assertEquals(
            false,
            LC112().hasPathSum1(null,0)
        )
    }
}