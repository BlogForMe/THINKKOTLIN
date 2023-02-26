package leetcode.tree

import java.util.LinkedList
import leetcode.ext.TreeNode

class LC104 {
    fun maxDepth1(root: TreeNode?): Int {
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

    fun maxDepth(root: TreeNode?): Int {
        val depth = 0
        if (root == null) return depth
        return dfsDepth(root, depth)
    }

    private fun dfsDepth(node: TreeNode?, depth: Int): Int {
        if (node == null) return depth
        val maxDepth = Math.max(dfsDepth(node.left, depth + 1), dfsDepth(node.right, depth + 1)) // 用max函数更直观
        return maxDepth
    }
}