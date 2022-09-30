package leetcode.tree

import leetcode.ext.TreeNode
import java.util.LinkedList

class LC513 {
    fun findBottomLeftValue1(root: TreeNode?): Int {
        val queue = LinkedList<TreeNode>()
        if (root != null) {
            queue.offer(root)
        }
        var leftNodeVal = root?.`val`
        while (queue.isNotEmpty()) {
            val size = queue.size
            leftNodeVal = queue.peek().`val` //每一行的第一个节点
            for (i in 0 until size) {
                val node = queue.poll()
                node?.left?.let { queue.offer(it) }
                node?.right?.let { queue.offer(it) }
            }
        }
        return leftNodeVal!! // queue为empty的时候退出，此时上一层存的节点就是最左边的节点
    }

    var mDepth = 0 //一开始不知道leetcode可以用全局变量，用对象返回还很麻烦，删掉了
    var result = -1

    fun findBottomLeftValue(root: TreeNode?): Int {
        if (root == null) return 0
        inOrderTraversal(root, mDepth)
        return result
    }

    // 最左边的节点最先访问到
    private fun inOrderTraversal(node: TreeNode?, depth: Int) {
        if (node == null) return
        inOrderTraversal(node.left, depth + 1)
        if (depth + 1 > mDepth) { // 判断层级，如果大于之前的深度，那么就更新深度和值
            mDepth = depth + 1
            result = node.`val`
        }
        inOrderTraversal(node.right, depth + 1)
    }

}