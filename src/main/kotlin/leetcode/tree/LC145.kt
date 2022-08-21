package leetcode.tree

import leetcode.ext.TreeNode
import java.util.LinkedList

class LC145 {
    //recurive
    fun postorderTraversal(root: TreeNode?): List<Int> {
        val linkedList = LinkedList<Int>()
        recursiveTraversal(root, linkedList)
        return linkedList
    }

    private fun recursiveTraversal(node: TreeNode?, linkedList: LinkedList<Int>) {
        if (node == null) return
        recursiveTraversal(node.left, linkedList)
        recursiveTraversal(node.right, linkedList)
        linkedList.add(node.`val`)
    }
}