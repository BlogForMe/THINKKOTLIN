package leetcode.tree.seach
import leetcode.ext.TreeNode

class LC538 {
    var sum = 0
    fun convertBST(root: TreeNode?): TreeNode? {
        if (root == null) return null
        convertBST(root.right)
        sum += root.`val`
        root.`val` = sum
        convertBST(root.left)
        return root
    }

    var pre = 0
    fun convertBST1(root: TreeNode?): TreeNode? {
        if (root == null) return null
        convertBST(root.right)
        root.`val` += pre
        pre = root.`val`
        convertBST(root.left)
        return root
    }
}