package leetcode.tree

import java.util.LinkedList
import leetcode.ext.TreeNode

class LC102 {
    //队列法
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        val layerList = LinkedList<List<Int>>()
        val queue = LinkedList<TreeNode>()
        if (root != null) {
            queue.offer(root)
        }
        while (queue.isNotEmpty()) {
            val layerSize = queue.size // queue大小，下面循环在不断变化，所以要先定义出来
            val linkedList = LinkedList<Int>()
            for (i in 0 until layerSize) {
                val headNode = queue.poll()
                linkedList.add(headNode.`val`)
                headNode.left?.let { queue.offer(it) }
                headNode.right?.let { queue.offer(it) }
            }
            layerList.add(linkedList)
        }
        return layerList
    }


    fun levelOrder1(root: TreeNode?): List<List<Int>> {
        val layerList = LinkedList<LinkedList<Int>>()
        if (root==null){
            return layerList
        }
        val depth = 0 // 层级
        return recursive(layerList, root, depth)
    }

    private fun recursive(layerList: LinkedList<LinkedList<Int>>, node: TreeNode?, depth: Int): List<List<Int>> {
        if (layerList.size <= depth) { //二维数组长度不超过这个层级,随想录这里是用 ==,不过我觉得<=更好
            val linkedList = LinkedList<Int>()
            layerList.add(linkedList)
        }
        node?.`val`?.let { layerList[depth].add(it) } // 拿到当前层级节点的值
        val mDepth = depth + 1
        if (node?.left != null) {
            recursive(layerList, node.left, mDepth)
        }
        if (node?.right != null) {
            recursive(layerList, node.right, mDepth)
        }
        return layerList
    }

}