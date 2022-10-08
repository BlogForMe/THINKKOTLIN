package leetcode.tree.seach

import leetcode.ext.TreeNode

class LC236 {
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        if (root == null) return null
//        val printData = root.`val`
//        println(printData)
        val leftNode = lowestCommonAncestor(root.left, p, q)
        val rightNode = lowestCommonAncestor(root.right, p, q)
        if (leftNode != null && rightNode != null) { // 如果左右子树都不为空，那么当前节点就是最近公共祖先节点
            return root
        }
        if (p != null && root.`val` == p.`val`) {   //碰到了其中一个节点返回
            return root
        } else if (q != null && root.`val` == q.`val`) {
            return root                             //碰到了其中一个节点返回
        }
        if (leftNode != null) return leftNode       //回溯之前碰到的节点
        if (rightNode != null) return rightNode
        return null
    }
}