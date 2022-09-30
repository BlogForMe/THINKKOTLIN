package leetcode.tree

import leetcode.ext.ConstructTree
import org.junit.Assert
import org.junit.Test


class LC513Test {

    @Test
    fun findBottomLeftValue() {
        Assert.assertEquals(
            1,
            LC513().findBottomLeftValue(ConstructTree.constructTree(arrayOf(2,1,3)))
        )
    }
}