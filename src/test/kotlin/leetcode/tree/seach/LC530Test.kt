package leetcode.tree.seach

import leetcode.ext.ConstructTree
import org.junit.Assert
import org.junit.Test

class LC530Test {

    @Test
    fun getMinimumDifference() {
        Assert.assertEquals(1, LC530().getMinimumDifference(ConstructTree.constructTree(arrayOf(4, 2, 6, 1, 3))))
        Assert.assertEquals(1, LC530().getMinimumDifference(ConstructTree.constructTree(arrayOf(1,0,48,null,null,12,49))))
    }
}