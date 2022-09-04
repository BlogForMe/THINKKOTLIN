package leetcode.tree

import leetcode.ext.Node
import java.util.LinkedList


class LC429 {
    fun levelOrder(root: Node?): List<List<Int>> {
        val result = LinkedList<ArrayList<Int>>()
        val queue = LinkedList<Node>()
        if (root != null) {
            queue.offer(root)
        }
        while (queue.isNotEmpty()) {
            val layoutSize = queue.size // 该层级的节点数
            val layerResult = ArrayList<Int>()
            for (i in 0 until layoutSize) {
                val pollNode = queue.poll()
                layerResult.add(pollNode.`val`)
                pollNode.children.forEach {
                    queue.offer(it)
                }
            }
            result.add(layerResult)
        }
        return result
    }
}