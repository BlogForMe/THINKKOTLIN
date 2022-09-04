package leetcode.tree

import leetcode.ext.TreeNode
import java.util.LinkedList
import java.util.Stack

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

    //迭代法
    fun postorderTraversal1(root: TreeNode?): List<Int> {
        var mRoot = root
        val resultList = LinkedList<Int>()
        val stack = Stack<TreeNode>()
        var preNode: TreeNode? = null
        while (mRoot != null || !stack.isEmpty()) {
            while (mRoot != null) {
                stack.push(mRoot)
                mRoot = mRoot.left
            }
            mRoot = stack.pop()
            if (mRoot?.right == null || mRoot.right == preNode) { // 一开始写成这样 mRoot == preNode
                resultList.add(mRoot.`val`)
                preNode = mRoot
                mRoot = null
            } else {
                stack.push(mRoot)
                mRoot = mRoot.right
            }
        }
        return resultList
    }
}