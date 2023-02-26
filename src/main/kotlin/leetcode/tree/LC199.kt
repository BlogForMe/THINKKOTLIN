package leetcode.tree

import java.util.LinkedList
import leetcode.ext.TreeNode

class LC199 {
    fun rightSideView(root: TreeNode?): List<Int> {
        val resultList = LinkedList<Int>()
        val queue = LinkedList<TreeNode>()
        if (root != null) {
            queue.add(root)
        }
        while (queue.isNotEmpty()) {
            val layoutSize = queue.size
            for (i in 0 until layoutSize) {
                val headNode = queue.poll()
                if (i == layoutSize - 1) {
                    resultList.add(headNode.`val`)
                }
                headNode?.left?.let { queue.offer(it) }
                headNode?.right?.let { queue.offer(it) }
            }
        }
        return resultList
    }
}