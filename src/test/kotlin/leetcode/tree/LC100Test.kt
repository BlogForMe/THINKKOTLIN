package leetcode.tree

import leetcode.ext.ConstructTree.constructTree
import org.junit.Assert.assertEquals
import org.junit.Test

class LC100Test {

    @Test
    fun isSameTree() {
        val tree1 = constructTree(arrayOf(1, 2, 3))
        val tree2 = constructTree(arrayOf(1, 2, 3))

//        assertEquals(true, LC100().isSameTree(tree1, tree2))
        assertEquals(true, LC100().isSameTree1(tree1, tree2))

    }
}