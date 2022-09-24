package leetcode.tree

import leetcode.ext.TreeNode

class LC404 {
    fun sumOfLeftLeaves(root: TreeNode?): Int {
        return dfsLeaves(root, 0)
    }

    /**
     * @param direction 0 右子树， 1：左子树
     */
    private fun dfsLeaves(node: TreeNode?, direction: Int): Int {
        if (node == null) return 0
        if (node.left == null && node.right == null && direction == 1) { // 左右子树为空，根据父亲节点的传入，判断它是左子树
            return node.`val`
        }
        val leftCount = dfsLeaves(node.left, 1)
        val rightCount = dfsLeaves(node.right, 0)
        return leftCount + rightCount
    }

}