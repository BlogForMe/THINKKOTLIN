package leetcode.tree.seach

import leetcode.ext.ConstructTree
import leetcode.ext.TreeNode
import leetcode.ext.TreeOperation
import org.junit.Test

import org.junit.Assert.*

class LC108Test {

    @Test
    fun sortedArrayToBST() {
        val searchTree = LC108().sortedArrayToBST(intArrayOf(-10, -3, 0, 5, 9))
        TreeOperation.show(searchTree)
//        val searchTree1 = LC108().sortedArrayToBST(intArrayOf(1,3))
//        TreeOperation.show(searchTree1)

    }
}