package leetcode.tree
import leetcode.ext.TreeNode

class LC654 {
    fun constructMaximumBinaryTree(nums: IntArray): TreeNode? {
        return buildTree(nums, 0, nums.size - 1)
    }

    private fun buildTree(nums: IntArray, start: Int, end: Int): TreeNode? {
        println("buildTree start $start end $end")
        if (start > end) return null            //分割的左右下标越界就退出
        val maxIndex = getMaxIndex(nums, start, end)
        val node = TreeNode(nums[maxIndex])     // 构造先序的父节点
        node.left = buildTree(nums, start, maxIndex - 1) // 构造左节点
        node.right = buildTree(nums, maxIndex + 1, end)
        return node
    }

    fun getMaxIndex(nums: IntArray, start: Int, end: Int): Int {
        var maxIndex = start
        for (i in start..end) {  // 在对应的数组范围内，找到最大值
            if (nums[maxIndex] < nums[i]) {
                maxIndex = i
            }
        }
        return maxIndex
    }
}