package leetcode.tree

import leetcode.ext.TreeNode
import java.util.LinkedList

class LC101 {

    fun isSymmetric(root: TreeNode?): Boolean {
        return leftRightSymmetric(root?.left, root?.right)
    }

    private fun leftRightSymmetric(nodeLeft: TreeNode?, nodeRight: TreeNode?): Boolean {
        if (nodeLeft == null && nodeRight != null) {
            return false
        } else if (nodeLeft != null && nodeRight == null) {
            return false
        } else if (nodeLeft?.`val` != nodeRight?.`val`) {
            return false
        } else if (nodeLeft == null && nodeRight == null) {
            return true //这里需要，否则就递归 溢出了
        }
        val leftFlag = leftRightSymmetric(nodeLeft?.left, nodeRight?.right)
        val rightFlag = leftRightSymmetric(nodeLeft?.right, nodeRight?.left)
        return leftFlag && rightFlag
    }

    fun isSymmetric1(root: TreeNode?): Boolean {
        val queue = LinkedList<TreeNode>()
        if (root != null) {
            root.left?.let { queue.offer(it) }
            root.right?.let { queue.offer(it) }
        }
        while (queue.isNotEmpty()) {
            val node1 = queue.poll()
            val node2 = queue.poll()
            if(node1==null&&node2==null){ // 一开始没写这个条件，提示超出时间限制
                return true
            }
            if (node1?.`val` != node2?.`val`) {
                return false
            }
            queue.offer(node1?.left)
            queue.offer(node2?.right)
            queue.offer(node1?.right)
            queue.offer(node2?.left)
        }
        return true
    }

    fun isSymmetric3(root: TreeNode?): Boolean {
        val queue = LinkedList<TreeNode>()
        if (root != null) {
            queue.offer(root)
        }
        while (queue.isNotEmpty()) {
            val layerSize = queue.size
            for (i in 0 until layerSize) {
//                val lastIndex = layerSize - 1 - i // 这样不可以,poll取出元素后，就少了元素越界了
                val headNode = queue.poll()

                val lastNode = queue.lastOrNull()
                if (headNode.`val` != lastNode?.`val`) {
                    return false
                }
                headNode.left?.let { queue.offer(it) }
                headNode.right?.let { queue.offer(it) }
            }
        }
        return true
    }
}