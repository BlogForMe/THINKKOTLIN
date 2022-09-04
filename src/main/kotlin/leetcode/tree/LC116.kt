package leetcode.tree

import leetcode.ext.Node
import java.util.*

class LC116 {
    fun connect(root: Node?): Node? {
        val queue = LinkedList<Node>()
        if (root != null) {
            queue.offer(root)
        }
        while (queue.isNotEmpty()) {
            val layerSize = queue.size
            for (i in 0 until layerSize) {
                val curNode = queue.poll()
                if (i < layerSize - 1) {
                    curNode.next = queue.peek()
                }
                curNode?.left?.let { queue.offer(it) }
                curNode?.right?.let { queue.offer(it) }
            }
        }
        return root
    }
}