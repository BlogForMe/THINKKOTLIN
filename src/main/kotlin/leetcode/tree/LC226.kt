package leetcode.tree

import leetcode.ext.TreeNode

class LC226 {
    //使用先序遍历
    fun invertTree(root: TreeNode?): TreeNode? {
        if (root == null) return null
        swapNode(root)
        invertTree(root.left)
        invertTree(root.right)
        return root
    }


    private fun swapNode(node: TreeNode?) {
        val temp = node?.left
        node?.left = node?.right
        node?.right = temp
    }
}