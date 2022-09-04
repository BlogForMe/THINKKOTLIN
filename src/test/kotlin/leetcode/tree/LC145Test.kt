package leetcode.tree

import leetcode.ext.ConstructTree
import leetcode.ext.TreeOperation
import org.junit.Assert
import org.junit.Test


class LC145Test {

    @Test
    fun postorderTraversal() {
        val constructTree = ConstructTree.constructTree(arrayOf(1, null, 2, 3))
//        val constructTree = ConstructTree.constructTree(arrayOf(3, 9, 4, null, null, 5, 7));
        // 将刚刚创建的树打印出来
        TreeOperation.show(constructTree)

//        val preorderTraversal = LC145().postorderTraversal(constructTree).toIntArray()
        val preorderTraversal = LC145().postorderTraversal1(constructTree).toIntArray()
        Assert.assertArrayEquals(intArrayOf(3, 2, 1), preorderTraversal)

    }

    @Test
    fun showTree(){
        val constructTree = ConstructTree.constructTree(arrayOf(3,9,20,null, null, 15, 7))
        // 将刚刚创建的树打印出来
        TreeOperation.show(constructTree)
    }
}