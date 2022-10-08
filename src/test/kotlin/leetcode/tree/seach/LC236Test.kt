package leetcode.tree.seach

import leetcode.ext.ConstructTree
import leetcode.ext.TreeNode
import org.junit.Assert
import org.junit.Test

class LC236Test {

    @Test
    fun lowestCommonAncestor() {
        val lowestCommonAncestor = LC236().lowestCommonAncestor(
            ConstructTree.constructTree(arrayOf(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4)), TreeNode(5),
            TreeNode(1)
        )
        println(lowestCommonAncestor)
        Assert.assertEquals(3,lowestCommonAncestor?.`val`)

        val lowestCommonAncestor1 = LC236().lowestCommonAncestor(
            ConstructTree.constructTree(arrayOf(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4)), TreeNode(5),
            TreeNode(4)
        )
        println(lowestCommonAncestor1)
        Assert.assertEquals(5,lowestCommonAncestor1?.`val`)


        val lowestCommonAncestor2 = LC236().lowestCommonAncestor(
            ConstructTree.constructTree(arrayOf(1, 2)), TreeNode(1),
            TreeNode(2)
        )
        println(lowestCommonAncestor2)
        Assert.assertEquals(1,lowestCommonAncestor2?.`val`)

    }
}