package leetcode.tree

import leetcode.ext.TreeNode

class LC105 {
//    val map = HashMap<Int, Int>()
//    var preNodeIndex = 0
    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        inorder.forEachIndexed { position, item -> //
            map[item] = position
        }
        return buildDFS(preorder, inorder, 0, inorder.size - 1)
    }

    private fun buildDFS(preorder: IntArray, inorder: IntArray, inBegin: Int, inEnd: Int): TreeNode? {
        if (inBegin > inEnd) {
            return null
        }
        val node = TreeNode(preorder[preNodeIndex])  // 根据先序遍历数组从 左子树到右子树构造节点
        val inIndex = map[preorder[preNodeIndex]]!! // 根据先序数组的节点的位置，分割中序遍历数组，拿到左右子树
        println("${preorder[preNodeIndex]} inBegin $inBegin inEnd $inEnd")
        preNodeIndex++
        node.left = buildDFS(preorder, inorder, inBegin, inIndex - 1)
        node.right = buildDFS(preorder, inorder, inIndex + 1, inEnd)
        return node
    }

    val map = HashMap<Int, Int>()
    var preNodeIndex = 0
    fun buildTree1(preorder: IntArray, inorder: IntArray): TreeNode? {
        inorder.forEachIndexed { position, item ->
            map[item] = position  // 获得 中序 value和index hash
            map.put(item,position)
        }
        return splitPreInOrder(preorder, 0, preorder.size - 1, inorder, 0, inorder.size - 1)
    }

    private fun splitPreInOrder(
        preorderArr: IntArray,
        preStart: Int,
        preEnd: Int,
        inorderArr: IntArray,
        inStart: Int,
        inEnd: Int
    ): TreeNode? {
        println(" preStart $preStart preEnd $preEnd inStart $inStart inEnd $inEnd")

        if (preStart > preEnd || inStart > inEnd) return null
        val inIndex = map[preorderArr[preStart]]!!  // 分割中序数组
        val node = TreeNode(preorderArr[preStart])

        val leftInBegin = inStart //左闭
        val leftInEnd = inIndex-1    // 右闭
        val leftPreBegin = preStart + 1 // 先序中节点的后一个位置，就是左子树的开始位置
        val leftPreEnd = preStart + (inIndex - inStart) // 其实位置 + 中序中左子树的长度

        node.left = splitPreInOrder(preorderArr, leftPreBegin, leftPreEnd, inorderArr, leftInBegin, leftInEnd)
        val rightInBegin = inIndex + 1 // 分割点的后一个位置
        val rightInEnd = inEnd
        val rightPreBegin = preStart + (inIndex - inStart) + 1 // 先序数组 左子树位置+1 后一个位置
        val rightPreEnd = preEnd
        node.right = splitPreInOrder(preorderArr, rightPreBegin, rightPreEnd, inorderArr, rightInBegin, rightInEnd)
        return node
    }
}