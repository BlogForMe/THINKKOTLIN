package leetcode.tree.seach

import leetcode.ext.ConstructTree
import org.junit.Assert
import org.junit.Test

class LC501Test {

    @Test
    fun findMode() {
        Assert.assertArrayEquals(intArrayOf(2), LC501().findMode(ConstructTree.constructTree(arrayOf(1, null, 2, 2))))
        Assert.assertArrayEquals(intArrayOf(0), LC501().findMode(ConstructTree.constructTree(arrayOf(0))))
    }
}