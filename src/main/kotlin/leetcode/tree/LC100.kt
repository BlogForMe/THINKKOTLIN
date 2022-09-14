package leetcode.tree

import leetcode.ext.TreeNode
import java.util.LinkedList

class LC100 {
    /**
     *  递归，这种类似于101官方解法， return p?.`val` == q?.`val` 再进行后续的比较，更容易理解
     */

    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        if (p == null && q != null) {
            return false
        } else if (p != null && q == null) {
            return false
        } else if (p == null && q == null) {
            return true
        }
        return p?.`val` == q?.`val` && isSameTree(p?.left, q?.left) && isSameTree(p?.right, q?.right)
    }

    /**
     * 队列
     */
    fun isSameTree1(p: TreeNode?, q: TreeNode?): Boolean {
        if (p == null && q != null) {
            return false
        } else if (p != null && q == null) {
            return false
        }
        val queue = LinkedList<TreeNode>()
        queue.offer(p)
        queue.offer(q)
        while (queue.isNotEmpty()) {
            val node1 = queue.poll()
            val node2 = queue.poll()
            if (node1 == null && node2 == null) { // continue后，因为null,就不会加入新的节点
                continue
            }
            if (node1?.`val` != node2?.`val`) {
                return false
            }
            queue.offer(node1?.left)
            queue.offer(node2?.left)
            queue.offer(node1?.right)
            queue.offer(node2?.right)
        }
        return true
    }

}