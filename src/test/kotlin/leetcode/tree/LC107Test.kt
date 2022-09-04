package leetcode.tree

import leetcode.ext.ConstructTree
import org.junit.Test

import org.junit.Assert.*

class LC107Test {

    @Test
    fun levelOrderBottom() {
        val constructTree = ConstructTree.constructTree(arrayOf(3, 9, 20, null, null, 15, 7))
        val levelOrder1 = LC107().levelOrderBottom(constructTree)
        println(levelOrder1)
    }
}