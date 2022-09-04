package leetcode.tree

import leetcode.ext.ConstructTree
import leetcode.ext.TreeOperation
import org.junit.Assert
import org.junit.Test

import org.junit.Assert.*

class LC111Test {

    @Test
    fun minDepth() {
        val constructTree = ConstructTree.constructTree(arrayOf(2,null,3,null,4,null,5,null,6))
        val minDepth = LC111().minDepth(constructTree)
        TreeOperation.show(constructTree)

        assertEquals(5,minDepth)
    }
}