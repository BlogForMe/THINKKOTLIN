package leetcode.tree

import java.util.LinkedList
import java.util.Stack
import leetcode.ext.TreeNode

class LC144 {
    //先序遍历
    fun preorderTraversal(root: TreeNode?): List<Int> {
        val linkedList = LinkedList<Int>()
        preTraversal(root, linkedList)
        return linkedList
    }

    private fun preTraversal(node: TreeNode?, linkedList: LinkedList<Int>) {
        if (node == null) return
        linkedList.add(node.`val`)
        preTraversal(node.left, linkedList)
        preTraversal(node.right, linkedList)
    }

    //迭代法
    fun preorderTraversal1(root: TreeNode?): List<Int> {
        val linkedList = LinkedList<Int>()
        val stack = Stack<TreeNode>()
        root?.let{
            stack.push(it)
        }
        while (!stack.empty()) {
            val popNode = stack.pop()
            popNode.`val`.let{
                linkedList.add(it)
            }
            popNode.right?.let {
                stack.push(it)
            }
            popNode.left?.let {
                stack.push(it)
            }
        }
        return linkedList
    }


}