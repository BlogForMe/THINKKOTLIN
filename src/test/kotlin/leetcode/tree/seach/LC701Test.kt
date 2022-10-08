package leetcode.tree.seach

import leetcode.ext.ConstructTree
import leetcode.ext.TreeOperation
import org.junit.Test

class LC701Test {

    @Test
    fun insertIntoBST() {
//        val insertIntoBST = LC701().insertIntoBST(ConstructTree.constructTree(arrayOf(4, 2, 7, 1, 3)), 5)
//        TreeOperation.show(insertIntoBST)

        val tree1 = ConstructTree.constructTree(
            arrayOf(5, null, 14, 10, 77, null, null, null, 95, null, null)
        )
        TreeOperation.show(tree1)

        val insertIntoBST1 = LC701().insertIntoBST1(tree1, 4)
        TreeOperation.show(insertIntoBST1)


        val insertIntoBST2 = LC701().insertIntoBST1(null, 5)
        println()
    }

    @Test
    fun insertIntoBST1() {
//        val insertIntoBST = LC701().insertIntoBST(ConstructTree.constructTree(arrayOf(4, 2, 7, 1, 3)), 5)
//        TreeOperation.show(insertIntoBST)

        val tree1 = ConstructTree.constructTree(
            arrayOf(5, null, 14, 10, 77, null, null, null, 95, null, null)
        )
        TreeOperation.show(tree1)

        val insertIntoBST1 = LC701().insertIntoBST(tree1, 4)
        TreeOperation.show(insertIntoBST1)


        val insertIntoBST2 = LC701().insertIntoBST(null, 5)
        println()
    }
}