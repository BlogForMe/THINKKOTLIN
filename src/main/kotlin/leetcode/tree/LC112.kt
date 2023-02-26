package leetcode.tree

import java.util.Stack
import leetcode.ext.TreeNode

class LC112 {
    fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {
        val pathStack = Stack<Int>()
        if (root != null) {
            pathStack.push(root.`val`) // root需要放在遍历外面，否则会push多次
        } else {
            return false //按照前面的规则 root==null ,0 应该是对的,但是题目说false,就单独加一句
        }
        return preOrderTraversal(root, targetSum, pathStack) // pathstack必须传进去，否则每次都new
    }

    private fun preOrderTraversal(root: TreeNode?, targetSum: Int, pathStack: Stack<Int>): Boolean {
        if (root?.left == null && root?.right == null) {
            var pathSum = 0
            pathStack.forEach {
                pathSum += it
            }
            println("pathSum $pathSum")
            if (pathSum == targetSum) {
                return true
            }
        }
        if (root?.left != null) {
            pathStack.push(root.left.`val`) // 有左节点，加入当前路径
            if (preOrderTraversal(root.left, targetSum, pathStack)) { //有路径是和 == targetSum 直接返回
                return true
            }
            pathStack.pop()  // 不会直接把上面的回退了，需要上一句遍历执行完回退后，才把自己回退了，此时已经到了叶子判断了 root?.left == null && root?.right == null
        }
        if (root?.right != null) {
            pathStack.push(root.right.`val`)
            if (preOrderTraversal(root.right, targetSum, pathStack)) { //有路径是和 == targetSum 直接返回
                return true
            }
            pathStack.pop()
        }
        return false
    }


    fun hasPathSum1(root: TreeNode?, targetSum: Int): Boolean {
        if (root == null) {
            return false //按照前面的规则 root==null ,0 应该是对的,但是题目说false,就单独加一句
        }
        val pathSum = root.`val`
        return preOrderDFS(root, pathSum, targetSum) // pathstack必须传进去，否则每次都new
    }

    private fun preOrderDFS(node: TreeNode, pathSum: Int, targetSum: Int): Boolean {
        val nodeValue = node.`val`
        println("nodeValue $nodeValue")
        if (node.left == null && node.right == null && targetSum == pathSum) {
            return true
        }

        if (node.left != null)
            if (preOrderDFS(node.left, pathSum + node.left.`val`, targetSum)) { // 这个直接放回，容易忘了
                return true
            }

        if (node.right != null)
            if (preOrderDFS(node.right, pathSum + node.right.`val`, targetSum)) {
                return true
            }
        return false
    }

}