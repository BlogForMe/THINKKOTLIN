package leetcode.tree.seach

import leetcode.ext.ConstructTree
import leetcode.ext.TreeNode
import leetcode.ext.TreeOperation
import org.junit.Test

import org.junit.Assert.*

class LC450Test {

    @Test
    fun deleteNode() {
        TreeOperation.show(ConstructTree.constructTree(arrayOf(5, 3, 6, 2, 4, null, 7)))

//        val deleteNode = LC450().deleteNode(ConstructTree.constructTree(arrayOf(5, 3, 6, 2, 4, null, 7)), 3)
//        TreeOperation.show(deleteNode)


//        val deleteNode1 = LC450().deleteNode(ConstructTree.constructTree(arrayOf(0)), 0)
//        TreeOperation.show(deleteNode1)
//
//        val deleteNode2 = LC450().deleteNode(ConstructTree.constructTree(arrayOf(5, 3, 6, 2, 4, null, 7)), 5)
//        TreeOperation.show(deleteNode2)
//
//        TreeOperation.show(ConstructTree.constructTree(arrayOf(50, 30, 70, null, 40, 60, 80)))
//        val deleteNode3 = LC450().deleteNode(ConstructTree.constructTree(arrayOf(50, 30, 70, null, 40, 60, 80)), 50)
//        TreeOperation.show(deleteNode3)
//        TreeOperation.show(ConstructTree.constructTree(arrayOf(3,2,5,null,null,4,10,null,null,8,15,7)))
//        val deleteNode3 = LC450().deleteNode(ConstructTree.constructTree(arrayOf(3,2,5,null,null,4,10,null,null,8,15,7)), 5)
//        TreeOperation.show(deleteNode3)

        val contree = ConstructTree.constructTree(arrayOf(8,0,31,null,6,28,45,1,7,25,30,32,49,null,4,null,null,9,26,29,null,null,42,47,null,2,5,null,12,null,27,null,null,41,43,46,48,null,3,null,null,10,19,null,null,33,null,null,44,null,null,null,null,null,null,null,11,18,20,null,37,null,null,null,null,14,null,null,22,36,38,13,15,21,24,34,null,null,39,null,null,null,16,null,null,23,null,null,35,null,40,null,17))
        TreeOperation.show(contree)


//        val deleteNode3 = LC450().deleteNode(ConstructTree.constructTree(arrayOf(3,2,5,null,null,4,10,null,null,8,15,7)), 5)
//        TreeOperation.show(deleteNode3)
    }
}