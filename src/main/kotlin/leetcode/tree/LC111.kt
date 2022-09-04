package leetcode.tree

import leetcode.ext.TreeNode
import java.util.LinkedList

class LC111 {
    fun minDepth(root: TreeNode?): Int {
        val queue = LinkedList<TreeNode>()
        if (root != null) {
            queue.offer(root)
        }
        var depth = 0
        while (queue.isNotEmpty()) {
            val layerSize = queue.size
            for (i in 0 until layerSize) {
                val pollNode = queue.poll()
                if (i == 0) {
                    depth++
                }
                if (pollNode.left == null && pollNode.right == null) {
                    return depth
                }
                pollNode?.left?.let { queue.offer(it) }
                pollNode?.right?.let { queue.offer(it) }
            }
        }
        return depth
    }
}