package leetcode.tree.seach

import leetcode.ext.ConstructTree
import leetcode.ext.TreeNode
import org.junit.Assert
import org.junit.Test

class LC235Test {

    @Test
    fun lowestCommonAncestor() {
//        val lowestCommonAncestor = LC235().lowestCommonAncestor(
//            ConstructTree.constructTree(arrayOf(6, 2, 8, 0, 4, 7, 9, null, null, 3, 5)), TreeNode(2),
//            TreeNode(8)
//        )
//        println(lowestCommonAncestor)
//        Assert.assertEquals(6, lowestCommonAncestor?.`val`)
//
//
//        val lowestCommonAncestor1 = LC235().lowestCommonAncestor(
//            ConstructTree.constructTree(arrayOf(6, 2, 8, 0, 4, 7, 9, null, null, 3, 5)), TreeNode(2),
//            TreeNode(4)
//        )
//        println(lowestCommonAncestor1)
//        Assert.assertEquals(2, lowestCommonAncestor1?.`val`)

        val lowestCommonAncestor2 = LC235().lowestCommonAncestor1(
            ConstructTree.constructTree(arrayOf(2, 1)), TreeNode(2),
            TreeNode(1)
        )
        println(lowestCommonAncestor2)
        Assert.assertEquals(2, lowestCommonAncestor2?.`val`)


    }

    @Test
    fun lowestCommonAncestor1() {
        val lowestCommonAncestor = LC235().lowestCommonAncestor(
            ConstructTree.constructTree(arrayOf(6, 2, 8, 0, 4, 7, 9, null, null, 3, 5)), TreeNode(2),
            TreeNode(8)
        )
        println(lowestCommonAncestor)
        Assert.assertEquals(6, lowestCommonAncestor?.`val`)


        val lowestCommonAncestor1 = LC235().lowestCommonAncestor(
            ConstructTree.constructTree(arrayOf(6, 2, 8, 0, 4, 7, 9, null, null, 3, 5)), TreeNode(2),
            TreeNode(4)
        )
        println(lowestCommonAncestor1)
        Assert.assertEquals(2, lowestCommonAncestor1?.`val`)

        val lowestCommonAncestor2 = LC235().lowestCommonAncestor1(
            ConstructTree.constructTree(arrayOf(2, 1)), TreeNode(2),
            TreeNode(1)
        )
        println(lowestCommonAncestor2)
        Assert.assertEquals(2, lowestCommonAncestor2?.`val`)
    }
}