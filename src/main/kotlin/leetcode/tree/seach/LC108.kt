package leetcode.tree.seach

import leetcode.ext.TreeNode

class LC108 {
    fun sortedArrayToBST(nums: IntArray): TreeNode? {
        return buildSearchTree(nums, 0, nums.size - 1)
    }

    private fun buildSearchTree(nums: IntArray, start: Int, end: Int): TreeNode? {
        if (start > end) {
            return null
        }
        val index = (start + end + 1) / 2
        val node = TreeNode(nums[index])
        println("node ${node.`val`} :  start $start end $end")
        node.left = buildSearchTree(nums, start, index - 1)
        node.right = buildSearchTree(nums, index + 1, end)
        return node
    }
}