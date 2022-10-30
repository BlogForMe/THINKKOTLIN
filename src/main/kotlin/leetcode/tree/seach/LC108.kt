package leetcode.tree.seach

import leetcode.ext.TreeNode

class LC108 {
    fun sortedArrayToBST(nums: IntArray): TreeNode? {
        return buildSearchTree(nums, 0, nums.size - 1)
    }

    private fun buildSearchTree(nums: IntArray, left: Int, right: Int): TreeNode? {
        if (left > right) {
            return null
        }
        val index = /*(start + end) / 2*/ left + (right - left) / 2
        val node = TreeNode(nums[index])
        println("node ${node.`val`} :  start $left end $right")
        node.left = buildSearchTree(nums, left, index - 1)
        node.right = buildSearchTree(nums, index + 1, right)
        return node
    }
}