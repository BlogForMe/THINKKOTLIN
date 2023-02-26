package leetcode.tree
import leetcode.ext.TreeNode

class LC572 {
    fun isSubtree(root: TreeNode?, subRoot: TreeNode?): Boolean {
        if (root == null && subRoot == null) {
            return true
        } else if (root == null && subRoot != null) {
            return false
        } else if (root != null && subRoot == null) {
            return false
        }
        return isSameTree(root, subRoot) || isSubtree(root?.left, subRoot) || isSubtree(root?.right, subRoot) //subRoot和root相同,subRoot和root左子树相同，subRoot和右子树相同
    }

    private fun isSameTree(node1: TreeNode?, node2: TreeNode?): Boolean {
        if (node1 == null && node2 == null) {
            return true
        } else if (node1 == null && node2 != null) {
            return false
        } else if (node1 != null && node2 == null) {
            return false
        }
        return node1?.`val` == node2?.`val` && isSameTree(node1?.left, node2?.left) && isSameTree(
            node1?.right,
            node2?.right
        )
    }
}