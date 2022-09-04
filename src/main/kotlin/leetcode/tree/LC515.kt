package leetcode.tree

import leetcode.ext.TreeNode
import java.util.LinkedList

class LC515 {
    fun largestValues(root: TreeNode?): List<Int> {
        val answer = ArrayList<Int>()
        val queue = LinkedList<TreeNode>()
        if (root != null) {
            queue.offer(root)
        }
        while (queue.isNotEmpty()) {
            val layerSize = queue.size
            var maxValue = Int.MIN_VALUE //最小值 , 每一层级都要初始化，否则拿到上一层级的值，就不是最小值，会有问题
            for (i in 0 until layerSize) {
                val pollNode = queue.poll()
                maxValue = pollNode.`val`.coerceAtLeast(maxValue) // 比较取最大值
                pollNode?.left?.let { queue.offer(it) }
                pollNode?.right?.let { queue.offer(it) }
            }
            answer.add(maxValue)
        }
        return answer
    }
}