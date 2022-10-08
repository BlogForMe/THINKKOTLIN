package leetcode.tree.seach

import leetcode.ext.TreeNode

class LC235 {
    /**
     * 很奇怪，IDE可以跑这个testcase没问题
     *[2,1]
     * 2
     * 1
     */
    fun lowestCommonAncestor1(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        if (root == null) return null
        if (p!!.`val` > q!!.`val`) {
            swap(p, q)
        }
        if (root.`val` > p.`val` && root.`val` < q.`val`) {
            return root
        }
        if (root.`val` == p.`val` && root.`val` < q.`val`) {
            return root
        }
        if (root.`val` == q.`val` && root.`val` > p.`val`) {
            return root
        }
        val leftNode = lowestCommonAncestor1(root.left, p, q)
        if (leftNode != null) return leftNode
        val rightNode = lowestCommonAncestor1(root.right, p, q)
        if (rightNode != null) return rightNode
        return null
    }

    fun swap(p: TreeNode, q: TreeNode?) {
        val temp = p.`val`
        p.`val` = q!!.`val`
        q.`val` = temp
    }

    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        if (root == null) return null
        if (root.`val` < p!!.`val` && root.`val` < q!!.`val`) { // 当前节点比p和q的值都小，那么一定p,q一定在右子树上，就往右边遍历
            val rightNode = lowestCommonAncestor(root.right, p, q)
            if (rightNode != null) return rightNode
        }

        if (root.`val` > p.`val` && root.`val` > q!!.`val`) {
            val leftNode = lowestCommonAncestor(root.left, p, q)
            if (leftNode != null) return leftNode
        }
        return root
    }
}