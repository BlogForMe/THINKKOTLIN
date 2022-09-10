package leetcode.tree

import leetcode.ext.TreeNode
import leetcode.ext.TreeOperation

class LC226 {

    var mRoot: TreeNode? = null
    fun invertTree(root: TreeNode?): TreeNode? {
        mRoot = root
        return traval(root)
    }

    //使用先序遍历
    fun traval(node: TreeNode?): TreeNode? {
        if (node == null) return null
        println(" \n \n node ${node.`val`}")
        TreeOperation.show(mRoot)
        traval(node.left)
        swapNode(node)
        traval(node.right)
        return node
    }


    private fun swapNode(node: TreeNode?) {
        val temp = node?.left
        node?.left = node?.right
        node?.right = temp
    }
}