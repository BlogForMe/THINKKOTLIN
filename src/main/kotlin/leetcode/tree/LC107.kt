package leetcode.tree

import leetcode.ext.TreeNode
import java.util.LinkedList

class LC107 {
    fun levelOrderBottom(root: TreeNode?): List<List<Int>> {
        val resultList = LinkedList<ArrayList<Int>>()
        val queue = LinkedList<TreeNode>()
        if (root != null) {
            queue.offer(root)
        }
        while (queue.isNotEmpty()) {
            val layerSize = queue.size // queue循环中 不断的变化
            val arrayList = ArrayList<Int>()
            for (i in 0 until layerSize) {
                val headNode = queue.poll()
                if (headNode != null) {
                    arrayList.add(headNode.`val`)
                    headNode.left?.let { queue.offer(it) } //别忘了 ?
                    headNode.right?.let { queue.offer(it) }
                }
            }
            resultList.addFirst(arrayList)
        }
        return resultList
    }
}