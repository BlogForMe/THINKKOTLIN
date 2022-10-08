package leetcode.tree.seach

import leetcode.ext.TreeNode

class LC701 {
    fun insertIntoBST1(root: TreeNode?, `val`: Int): TreeNode? {
        if (root == null) return TreeNode(`val`) //有一个这个test case  [] 5 ,空树的话返回 [5]

        if (`val` < root.`val`) { // 插入点小于当前节点，往左子树中插入
            insertIntoBST1(root.left, `val`)
        }
        if (`val` > root.`val`) {
            insertIntoBST1(root.right, `val`)
        }
        // 一开始这个放前面导致添加了两个5的左节点，因为 insertIntoBST(root.left, `val`)又走了一次
        val treeNode = TreeNode(`val`) // 只有一次机会走这个
        if (root.right == null && `val` > root.`val`) { //  待插入点大于当前节点，所以要插入右子树中，此时右子树为空，那么直接插入
            root.right = treeNode
        } else if (root.left == null && `val` < root.`val`) {
            root.left = treeNode
        }
        return root
    }

    fun insertIntoBST(root: TreeNode?, `val`: Int): TreeNode? {
        if (root == null) {
            return TreeNode(`val`)
        }
        if (`val` < root.`val`) { // 插入点小于当前节点，往左子树中插入
            root.left = insertIntoBST1(root.left, `val`)
        }
        if (`val` > root.`val`) {
            root.right = insertIntoBST1(root.right, `val`)
        }
        return root
    }
}