package leetcode.tree.seach

import leetcode.ext.TreeNode

class LC450 {
    fun deleteNode(root: TreeNode?, key: Int): TreeNode? {
        if (root == null) return null
        if (key < root.`val`) {
            root.left = deleteNode(root.left, key)
        } else if (key > root.`val`) {
            root.right = deleteNode(root.right, key)
        }

        if (key == root.`val`) {
            if (root.right != null) {   //如果右节点不为空
                val node = root.right //右节点4 推到删除的节点位置
                node.left = root.left           // 此时左节点4在在删除节点位置，它的左子树指向之前右节点2
                return node
            } else if (root.left != null) {            //如果左节点不为空
                val node = root.left  // 左节点 2 推到删除的节点位置
                node.right = root.right         //此时左节点2在在删除节点位置，它的右子树指向之前右节点4
                return node
            } else {
                return null //[0] 0 因为这个testcase 会返回[0]和预期不一致
            }
        }
        return root
    }
}