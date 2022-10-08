package leetcode.tree.seach

import leetcode.ext.TreeNode

class LC501 {
    val array = ArrayList<Int>()
    fun findMode(root: TreeNode?): IntArray {
        inDFS(root)
        return array.toIntArray()
    }

    var preNode: TreeNode? = null
    var maxCount = 0
    var count = 0
    private fun inDFS(node: TreeNode?) {
        val printNode = node?.`val`
        println("printNode $printNode")
        if (node == null) {
            return
        }
        inDFS(node.left)
        if (preNode != null && preNode!!.`val` == node.`val`) {
            count++
        } else {
            count = 1
        }
        if (count == maxCount) {
            array.add(node.`val`)
        }
        if (count > maxCount) {
            maxCount = count//这一步一开始不知道放哪里,看了一眼随想录答案
            array.clear() // 有更大的值，清空之前的集合
            array.add(node.`val`)
        }
        preNode = node
        inDFS(node.right)
    }
}