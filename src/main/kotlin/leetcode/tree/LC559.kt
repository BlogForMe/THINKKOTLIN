package leetcode.tree

import leetcode.ext.Node
import java.util.LinkedList
import kotlin.math.max

class LC559 {
    fun maxDepth(root: Node?): Int {
        if (root == null) return 0
        var maxDepth = 0
        root.children.forEach {
            val depth = maxDepth(it)
            maxDepth = Math.max(maxDepth, depth)
        }
        return maxDepth + 1
    }

    fun maxDepth1(root: Node?): Int {
        val queue = LinkedList<Node>()
        if (root != null) {
            queue.offer(root)
        }
        var maxDepth = 0
        while (queue.isNotEmpty()) {
            val layerSize = queue.size
            maxDepth++
            for (i in 0 until layerSize) {
                val pollNode = queue.poll()
                pollNode.children.forEach {
                    if (it != null)
                        queue.offer(it)
                }
            }
        }
        return maxDepth
    }
}