package leetcode.tree

import leetcode.ext.ConstructTree
import leetcode.ext.TreeOperation
import org.junit.Assert
import org.junit.Test

import org.junit.Assert.*

class LC226Test {

    @Test
    fun invertTree() {
        val constructTree = ConstructTree.constructTree(arrayOf(4,2,7,1,3,6,9))
//        TreeOperation.show(constructTree)
//        val invertTree = LC226().invertTree(constructTree)
        val invertTree1 = LC226().invertTree1(constructTree)
        TreeOperation.show(invertTree1)
    }
}