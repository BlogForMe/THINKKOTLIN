package leetcode.tree.seach
import leetcode.ext.TreeNode

class LC450 {
    fun deleteNode(root: TreeNode?, key: Int): TreeNode? {
        if (root == null) return null //情况一
        if (key < root.`val`) {
            root.left = deleteNode(root.left, key)
        } else if (key > root.`val`) {
            root.right = deleteNode(root.right, key)
        }

        if (key == root.`val`) {
            if (root.right == null && root.left == null) {
                return null // 情况2  [0] 0 因为这个testcase 会返回[0]和预期不一致
            } else if (root.left != null && root.right == null) {            //情况三 如果左节点不为空
                val node = root.left  // 左节点 2 推到删除的节点位置
                if(root.right!=null){               //这两句可以去掉
                    node.right = root.right         //此时左节点2在在删除节点位置，它的右子树指向之前右节点4
                }
                return node
            } else if (root.right != null && root.left == null) {  //情况四 如果右节点不为空
                val node = root.right //右节点4 推到删除的节点位置
                if(root.left!=null){                 //这两句可以去掉
                    node.left = root.left           // 此时左节点4在在删除节点位置，它的左子树指向之前右节点2
                }
                return node
            } else {
                val rightNode = root.right //情况五
                var leftNode = rightNode?.left
                while (leftNode?.left!= null) {
                    leftNode = leftNode.left
                }
                if (leftNode != null) {
                    leftNode.left = root.left
                } else {
                    rightNode.left = root.left
                }
                root.left = null
                return rightNode
            }
        }
        return root
    }
}