package leetcode.tree.seach

import leetcode.ext.ConstructTree
import leetcode.ext.TreeOperation
import org.junit.Test

class LC538Test {
    @Test
    fun convertBST() {
        val convertTree =LC538().convertBST(ConstructTree.constructTree(arrayOf(4,1,6,0,2,5,7,null,null,null,3,null,null,null,8)))
        val convertTree1 =LC538().convertBST(ConstructTree.constructTree(arrayOf(1,0,2)))
        val convertTree2 =LC538().convertBST(ConstructTree.constructTree(arrayOf(3,2,4,1)))
        TreeOperation.show(convertTree)
        TreeOperation.show(convertTree1)
        TreeOperation.show(convertTree2)
    }
}