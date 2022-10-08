package leetcode.tree.seach

import leetcode.ext.ConstructTree
import leetcode.ext.TreeNode
import leetcode.ext.TreeOperation
import org.junit.Test

import org.junit.Assert.*

class LC450Test {

    @Test
    fun deleteNode() {

//        val deleteNode = LC450().deleteNode(ConstructTree.constructTree(arrayOf(5, 3, 6, 2, 4, null, 7)), 3)
//        TreeOperation.show(deleteNode)
//
//        val deleteNode1 = LC450().deleteNode(ConstructTree.constructTree(arrayOf(0)), 0)
//        TreeOperation.show(deleteNode1)
//
//        val deleteNode2 = LC450().deleteNode(ConstructTree.constructTree(arrayOf(5, 3, 6, 2, 4, null, 7)), 5)
//        TreeOperation.show(deleteNode2)

        TreeOperation.show(ConstructTree.constructTree(arrayOf(50,30,70,null,40,60,80)))
        val deleteNode3 = LC450().deleteNode(ConstructTree.constructTree(arrayOf(50,30,70,null,40,60,80)), 50)
        TreeOperation.show(deleteNode3)
    }
}