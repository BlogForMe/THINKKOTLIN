package leetcode.tree.seach

import leetcode.ext.TreeNode
import java.util.LinkedList

class LC98 {
    /**
     */
    fun isValidBST1(root: TreeNode?): Boolean {
        if (root == null) return true
        return (root.left == null || root.left.`val` < root.`val`) && isValidBST1(root.left) &&
                (root.right == null || root.right.`val` > root.`val`) && isValidBST1(root.right)
    }

//    fun isValidBST2(root: TreeNode?): Boolean {
//        if (root == null) return true
//        val validBST = isValidBST(root.left, root.left.`val`, 0)
//        if (!validBST) {
//            return false
//        }
//        val validBST1 = isValidBST(root.right, root.`val`, 1)
//        if (!validBST1) {
//            return false
//        }
//        return true
//    }
//
//    fun isValidBST(node: TreeNode?, targetNum: Int, left: Int): Boolean {
//        if (node == null) return true
//        if (left == 0 && node.`val` > targetNum) {
//            return false
//        } else if (left == 1 && node.`val` < targetNum) {
//            return false
//        }
//        if (!isValidBST(node.left, targetNum, 0)) {
//            return false
//        }
//        if (!isValidBST(node.right, targetNum, 1)) {
//            return false
//        }
//        return true
//    }


    val list = LinkedList<Int>()
    fun isValidBST3(root: TreeNode?): Boolean {
        dfsTraversal(root) // 中序遍历递归 得到list数组
        for (i in 0 until list.size - 1) { // 比较数组的前后节点大大小
            if (list[i] >= list[i + 1]) { // 如果前面节点值更大，那么直接返回false, ==也不行
                return false
            }
        }
        return true
    }

    private fun dfsTraversal(root: TreeNode?) {
        if (root == null) return
        dfsTraversal(root.left)
        list.add(root.`val`)
        dfsTraversal(root.right)
    }


    var preNode: TreeNode? = null
    fun isValidBST4(root: TreeNode?): Boolean {
        if (root == null) return true
        if (!isValidBST4(root.left)) {
            return false
        }
        if (preNode != null && preNode!!.`val` >= root.`val`) {
            return false
        }
        preNode = root
        if (!isValidBST4(root.right)) {
            return false
        }
        return true
    }


}