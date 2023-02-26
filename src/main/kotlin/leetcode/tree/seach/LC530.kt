package leetcode.tree.seach
import leetcode.ext.TreeNode

class LC530 {
    var preNode: TreeNode? = null
    var miniNum = Int.MAX_VALUE
    fun getMinimumDifference(root: TreeNode?): Int {
        if (root == null) return Int.MAX_VALUE
        getMinimumDifference(root.left)
        if (preNode != null) {
            val gapNum = root.`val` - preNode!!.`val` //这里和下面可以简化成 Math.min()
            if (gapNum < miniNum) {
                miniNum = gapNum
            }
        }
        preNode = root
        getMinimumDifference(root.right)
        return miniNum
    }
}