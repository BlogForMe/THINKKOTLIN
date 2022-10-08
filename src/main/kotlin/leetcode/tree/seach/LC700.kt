package leetcode.tree.seach

import leetcode.ext.TreeNode

class LC700 {
    fun searchBST(root: TreeNode?, `val`: Int): TreeNode? {
        if (root == null) return null
        if (root.`val` == `val`) {
            return root
        }
        val nodeLeft = searchBST(root.left, `val`)
        if (nodeLeft != null) {
            return nodeLeft
        }
        val nodeRight = searchBST(root.right, `val`)
        if (nodeRight != null) {
            return nodeRight
        }
        return null
    }

    fun searchBST1(root: TreeNode?, `val`: Int): TreeNode? {
        if (root == null) return null
        var node: TreeNode? = root.left
        if (root.`val` == `val`) {
            return root
        }
        if (root.`val` < `val`) {
            node = root.right
        }
        return searchBST1(node, `val`)
    }
}