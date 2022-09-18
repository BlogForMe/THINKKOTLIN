package leetcode.tree

import leetcode.ext.TreeNode
import java.util.LinkedList


class LC222 {
    /**
     *  DFS 普通二叉树解法
     */
    fun countNodes7(root: TreeNode?): Int {
        if (root == null) return 0
        val leftCount = countNodes(root.left)
        val rightCount = countNodes(root.right)
        return leftCount + rightCount + 1
    }


    /**
     * BFS
     */
    fun countNodes1(root: TreeNode?): Int {
        val queue = LinkedList<TreeNode>()
        if (root != null) {
            queue.offer(root)
        }
        var count = 0
        while (queue.isNotEmpty()) {
            val size = queue.size
            for (i in 0 until size) {
                val treeNode = queue.poll()
                count++
                treeNode.left?.let { queue.offer(it) }
                treeNode.right?.let { queue.offer(it) }
            }
        }
        return count
    }

    fun countNodes(root: TreeNode?): Int {
        if (root == null) return 0
        var leftNode = root.left
        var depthLeft = 0 //左子树深度
        while (leftNode != null) {
            leftNode = leftNode.left
            depthLeft++
        }
        var rightNode = root.right
        var depthRight = 0
        while (rightNode != null) {
            rightNode = rightNode.right
            depthRight++
        }
        if (depthLeft == depthRight) {
            return (2 shl depthLeft) - 1 // 节点数
        }
        val leftNums = countNodes(root.left)
        val rightNums = countNodes(root.right)
        return leftNums + rightNums + 1
    }


    fun countNodes3(root: TreeNode?): Int {
        if (root == null) return 0
        var leftNode = root.left
        var depthLeft = 0 //左子树深度
        while (leftNode != null) {
            leftNode = leftNode.left
            depthLeft++
        }
        var rightNode = root.right
        var depthRight = 0
        while (rightNode != null) {
            rightNode = rightNode.right
            depthRight++
        }
        val leftNums = countNodes(root.left)
        val rightNums = countNodes(root.right)
        if (depthLeft == depthRight) {
            return (2 shl depthLeft) - 1 // 节点数
        }
        return leftNums + rightNums + 1
    }


}


