package leetcode.tree

import leetcode.ext.ConstructTree
import org.junit.Test

import org.junit.Assert.*

class LC104Test {

    @Test
    fun maxDepth() {
        val tree2 = ConstructTree.constructTree(arrayOf(3, 9, 20, null, null, 15, 7))
        assertEquals(3, LC104().maxDepth(tree2))
    }
}