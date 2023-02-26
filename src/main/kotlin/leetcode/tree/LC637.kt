package leetcode.tree

import java.util.LinkedList
import leetcode.ext.TreeNode

class LC637 {
    fun averageOfLevels(root: TreeNode?): DoubleArray {
        val resultList = ArrayList<Double>()
        val queue = LinkedList<TreeNode>()
        if (root != null) {
            queue.offer(root)
        }
        while (queue.isNotEmpty()) {
            val layoutSize = queue.size
            var layerSum = 0.toDouble() // 注意这里转成Double类型
            for (i in 0 until layoutSize) {
                val node = queue.poll()
                layerSum += node.`val`
                node?.left?.let { queue.offer(it) }
                node?.right?.let { queue.offer(it) }
            }
            val average = layerSum  / layoutSize
            resultList.add(average)
        }
        return resultList.toDoubleArray()
    }
}