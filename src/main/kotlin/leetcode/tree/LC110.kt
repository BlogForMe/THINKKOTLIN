package leetcode.tree

import leetcode.ext.TreeNode

class LC110 {
    fun isBalanced(root: TreeNode?): Boolean {
        return postTraversal(root) != -1
    }

    private fun postTraversal(node: TreeNode?): Int {
        if (node == null) return 0
        val leftDepth = postTraversal(node.left)
        val rightDepth = postTraversal(node.right)
        if (leftDepth == -1 || rightDepth == -1) { // 子节点已经有不是平衡的节点 直接返回，来判断
            return -1
        }
        val isBalance = Math.abs(leftDepth - rightDepth) <= 1
        if (isBalance) {
            return Math.max(leftDepth, rightDepth) + 1
        }
        return -1
    }
}