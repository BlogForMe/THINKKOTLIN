package leetcode.tree

import leetcode.ext.ConstructTree
import leetcode.ext.TreeOperation
import org.junit.Assert
import org.junit.Test

import org.junit.Assert.*

class LC101Test {

    @Test
    fun isSymmetric() {
//        val constructTree = ConstructTree.constructTree(arrayOf(1, 2, 2, 3, 4, 4, 3))
        val constructTree = ConstructTree.constructTree(arrayOf(1, 2, 2, null, 3, null, 3))
//        val constructTree = ConstructTree.constructTree(arrayOf(1,2,2,null,3,null,3))
        TreeOperation.show(constructTree)


//        assertEquals(true, LC101().isSymmetric(ConstructTree.constructTree(arrayOf(1, 2, 2, 3, 4, 4, 3))))
//        assertEquals(false, LC101().isSymmetric(ConstructTree.constructTree(arrayOf(1, 2, 2, null, 3, null, 3))))

        assertEquals(true, LC101().isSymmetric1(ConstructTree.constructTree(arrayOf(1, 2, 2, 3, 4, 4, 3))))
        assertEquals(false, LC101().isSymmetric1(ConstructTree.constructTree(arrayOf(1, 2, 2, null, 3, null, 3))))

    }
}