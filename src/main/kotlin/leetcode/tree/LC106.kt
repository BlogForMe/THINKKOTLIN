package leetcode.tree

import leetcode.ext.TreeNode

class LC106 {

    fun buildTree(inorder: IntArray, postorder: IntArray): TreeNode? {
        if (inorder.isEmpty() && postorder.isEmpty()) {
            return null
        }
        val node = TreeNode(postorder[postorder.size - 1]) //postorder.size用的地方多，可以提取出来
        val index = getIndex(node, inorder)
        node.left = buildTree(inorder.copyOfRange(0, index), postorder.copyOfRange(0, index)) // copyOfRange数组效率低
        node.right = buildTree(
            inorder.copyOfRange(index + 1, inorder.size), postorder.copyOfRange(index, postorder.size - 1)
        ) // 注意copyOfRange(0,2)获取的是index 0,1两个元素
        return node
    }

    fun getIndex(node: TreeNode, inorder: IntArray): Int {
        for (i in inorder.indices) {
            if (node.`val` == inorder[i]) {
                return i
            }
        }
        return 0
    }


    val map = HashMap<Int, Int>()
    fun buildTree1(inorder: IntArray, postorder: IntArray): TreeNode? {
        if (inorder.isEmpty() && postorder.isEmpty()) {
            return null
        }
        val inStart = 0
        val inEnd = inorder.size - 1
        val postStart = 0
        val postEnd = postorder.size - 1
        inorder.forEachIndexed { position, item ->
            map[item] = position
        }
        return buildDFSTree(inStart, inEnd, postStart, postEnd, inorder, postorder)
    }

    // 数组不变，只改变下标
    private fun buildDFSTree(
        inStart: Int,
        inEnd: Int,
        postStart: Int,
        postEnd: Int,
        inorderArr: IntArray,
        postorderArr: IntArray
    ): TreeNode? {
        println(" inStart $inStart inEnd $inEnd  postStart $postStart postEnd $postEnd")
        if (inStart > inEnd || postStart > postEnd) { // 因为是左闭右闭的方案，所以这里不能用 >= ,否则叶子节点无法构造出来
            return null
        }
        val node = TreeNode(postorderArr[postEnd]) //postorder.size用的地方多，可以提取出来
        val index = map[postorderArr[postEnd]] ?: 0 // 这里要改

        /**
         * 切割左子树,这种坐标定义好更清晰
         */
        val leftInBegin = inStart
        val leftInEnd = index - 1 // 左闭右闭
        val leftPostBegin = postStart
        val leftPostEnd = postStart + (index - inStart - 1) //(index - inStart) 左子树的长度, 因为选择是左闭右闭的方案，所以自身也-1

        node.left = buildDFSTree(
            leftInBegin, leftInEnd, leftPostBegin, leftPostEnd,
            inorderArr,
            postorderArr
        )

        /**
         * 切割右子树
         */
        val rightInBegin = index + 1
        val rightInEnd = inEnd
        val rightPostBegin = postStart + index - inStart //(index - inStart) 这里不用-1,因为左子树的右边就是右子树，所以右子树就是从这个位置开始的
        val rightPostEnd = postEnd - 1

        node.right = buildDFSTree(
            rightInBegin, rightInEnd, rightPostBegin, rightPostEnd,
            inorderArr,
            postorderArr
        )
        return node
    }
}