package leetcode.tree

import leetcode.ext.TreeNode
import java.util.LinkedList
import kotlin.math.min

class LC111 {
    fun minDepth1(root: TreeNode?): Int {
        val queue = LinkedList<TreeNode>()
        if (root != null) {
            queue.offer(root)
        }
        var depth = 0
        while (queue.isNotEmpty()) {
            val layerSize = queue.size
            depth++ // 不用放下面判断，直接是一层新的
            for (i in 0 until layerSize) {
                val pollNode = queue.poll()
                if (pollNode.left == null && pollNode.right == null) {
                    return depth
                }
                pollNode?.left?.let { queue.offer(it) }
                pollNode?.right?.let { queue.offer(it) }
            }
        }
        return depth
    }

    fun minDepth(root: TreeNode?): Int {
        if (root == null) return 0
        //左子节点和右子节点都不为空，然后取最小值才有意义，否则就是错的
        if (root.left != null && root.right != null) { // 左右都不为空
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1
        } else if (root.left == null) { //左不为空
            return minDepth(root.right) + 1
        }
        return minDepth(root.left) + 1 //右不为空
    }
//    https://leetcode.cn/problems/minimum-depth-of-binary-tree/solution/bfshe-dfsliang-chong-fang-shi-jie-jue-by-g4eh/
}