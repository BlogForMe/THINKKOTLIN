package leetcode.tree

import leetcode.ext.TreeNode
import java.util.LinkedList

class LC104 {
    fun maxDepth(root: TreeNode?): Int {
        val queue = LinkedList<TreeNode>()
        var depth = 0
        if (root != null) {
            queue.offer(root)
        }
        while (queue.isNotEmpty()) {
            val layerSize = queue.size
            for (i in 0 until layerSize) {
                val pollNode = queue.poll()
                pollNode?.left?.let { queue.add(it) }
                pollNode?.right?.let { queue.add(it) }
                if (i == layerSize - 1) {
                    depth++
                }
            }
        }
        return depth
    }
}