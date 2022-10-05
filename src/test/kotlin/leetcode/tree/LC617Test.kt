package leetcode.tree

import leetcode.ext.ConstructTree
import leetcode.ext.TreeOperation
import org.junit.Test

import org.junit.Assert.*

class LC617Test {

    @Test
    fun mergeTrees() {

        val mergeTrees = LC617().mergeTrees(
            ConstructTree.constructTree(arrayOf(1, 3, 2, 5)),
            ConstructTree.constructTree(arrayOf(2, 1, 3, null, 4, null, 7))
        )
        TreeOperation.show(mergeTrees)
    }
}