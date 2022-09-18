package leetcode.tree

import leetcode.ext.ConstructTree
import leetcode.ext.TreeOperation
import org.junit.Assert
import org.junit.Test

import org.junit.Assert.*

class LC257Test {

    @Test
    fun binaryTreePaths() {
        val binaryTreePaths = LC257().binaryTreePaths(ConstructTree.constructTree(arrayOf(1, 2, 3, null, 5)))
        println(binaryTreePaths)
//        TreeOperation.show(binaryTreePaths)
//        Assert.assertArrayEquals(intArrayOf(1, 2),.toIntArray())

    }
}