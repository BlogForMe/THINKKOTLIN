package leetcode.tree.seach

import leetcode.ext.ConstructTree
import leetcode.ext.TreeOperation
import org.junit.Assert
import org.junit.Test


class LC98Test {

    @Test
    fun isValidBST() {
//        TreeOperation.show(ConstructTree.constructTree(arrayOf(5, 4, 6, null, null, 3, 7)))
//        Assert.assertEquals(false, LC98().isValidBST(ConstructTree.constructTree(arrayOf(5, 1, 4, null, null, 3, 6))))
//        Assert.assertEquals(true, LC98().isValidBST(ConstructTree.constructTree(arrayOf(2, 1, 3))))
//        Assert.assertEquals(false, LC98().isValidBST(ConstructTree.constructTree(arrayOf(5, 4, 6, null, null, 3, 7))))
//        Assert.assertEquals(false, LC98().isValidBST(ConstructTree.constructTree(arrayOf(2,2,2))))

    }

    @Test
    fun isValidBST4() {
        TreeOperation.show(ConstructTree.constructTree(arrayOf(5, 4, 6, null, null, 3, 7)))
        Assert.assertEquals(false, LC98().isValidBST4(ConstructTree.constructTree(arrayOf(5, 1, 4, null, null, 3, 6))))
        Assert.assertEquals(true, LC98().isValidBST4(ConstructTree.constructTree(arrayOf(2, 1, 3))))
        Assert.assertEquals(false, LC98().isValidBST4(ConstructTree.constructTree(arrayOf(5, 4, 6, null, null, 3, 7))))
        Assert.assertEquals(false, LC98().isValidBST4(ConstructTree.constructTree(arrayOf(2,2,2))))

    }

    @Test
    fun isValidBST2() {
    }
}