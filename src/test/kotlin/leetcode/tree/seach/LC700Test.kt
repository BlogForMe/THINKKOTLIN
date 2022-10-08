package leetcode.tree.seach

import leetcode.ext.ConstructTree
import leetcode.ext.TreeOperation
import org.junit.Test

import org.junit.Assert.*

class LC700Test {

    @Test
    fun searchBST() {
        val searchBST = LC700().searchBST(ConstructTree.constructTree(arrayOf(4, 2, 7, 1, 3)), 2)
        TreeOperation.show(searchBST)

        val searchBST1 = LC700().searchBST(ConstructTree.constructTree(arrayOf(4, 2, 7, 1, 3)), 5)
        TreeOperation.show(searchBST1)
    }

    @Test
    fun searchBST1(){
        val searchBST = LC700().searchBST1(ConstructTree.constructTree(arrayOf(4, 2, 7, 1, 3)), 2)
        TreeOperation.show(searchBST)

        val searchBST1 = LC700().searchBST1(ConstructTree.constructTree(arrayOf(4, 2, 7, 1, 3)), 5)
        TreeOperation.show(searchBST1)
    }
}