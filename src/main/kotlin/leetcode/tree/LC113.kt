package leetcode.tree

import leetcode.ext.TreeNode
import java.util.LinkedList
import java.util.Stack

class LC113 {
    val resultList = LinkedList<List<Int>>()
    fun pathSum(root: TreeNode?, targetSum: Int): List<List<Int>> {
        if (root == null) return resultList
        val stackList = Stack<Int>()
        stackList.add(root.`val`)
        preDFS(root, stackList, targetSum)
        return resultList
    }

    private fun preDFS(node: TreeNode, pathList: Stack<Int>, targetSum: Int) {
        val data = node.`val`
        println(data)
        if (node.left == null && node.right == null && pathSum(pathList) == targetSum) {
            resultList.add(pathList.toMutableList().toList())
        }
        if (node.left != null) {
            pathList.push(node.left.`val`)
            preDFS(node.left, pathList, targetSum)
            pathList.pop()
        }
        if (node.right != null) {
            pathList.push(node.right.`val`)
            preDFS(node.right, pathList, targetSum)
            pathList.pop()
        }
    }

    fun pathSum(pathList: Stack<Int>): Int {
        var sum = 0
        pathList.forEach {
            sum += it
        }
        return sum
    }

    val pathList = LinkedList<Int>()
    fun pathSum1(root: TreeNode?, targetSum: Int): List<List<Int>> {
        if (root == null) return resultList
        val stackList = Stack<Int>()
        stackList.add(root.`val`)
        preTraversal(root, targetSum - root.`val`)
        return resultList
    }

    private fun preTraversal(node: TreeNode?, targetSum: Int) {
        if (node == null) return
        val data = node.`val`
        println(data)
        pathList.offer(node.`val`)
        if (node.left == null && node.right == null && targetSum == 0) {
            resultList.add(pathList.toMutableList())
        }
        if (node.left != null)
            preTraversal(node.left, targetSum - node.left.`val`)
        if (node.right != null)
            preTraversal(node.right, targetSum - node.right.`val`)
        pathList.pop()
    }

    fun pathSum2(root: TreeNode?, targetSum: Int): List<List<Int>> {
        if (root == null) return resultList
        val stackList = Stack<Int>()
        stackList.add(root.`val`)
        preDFSTraversal(root, targetSum)
        return resultList
    }

    private fun preDFSTraversal(node: TreeNode?, targetSum: Int) {
        if (node == null) return
        val data = node.`val`
        println(data)
        val targetSum = targetSum - node.`val`
        pathList.offer(node.`val`)
        if (node.left == null && node.right == null && targetSum == 0) {
            resultList.add(pathList.toMutableList())
        }
        preDFSTraversal(node.left, targetSum)
        preDFSTraversal(node.right, targetSum)
        pathList.pop()
    }
}