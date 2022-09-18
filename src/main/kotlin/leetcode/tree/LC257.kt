package leetcode.tree

import leetcode.ext.TreeNode
import java.util.*


class LC257 {
//    fun binaryTreePaths(root: TreeNode?): List<String> {
//        val result = LinkedList<String>()
//        if (root == null) return result
//
////        dfs(root, result, root.`val`.toString())
//        dfs(root, result, root.`val`.toString())
//        return result
//    }

//    private fun dfs(node: TreeNode?, result: LinkedList<String>, path: String) {
//        if (node == null) return
//        if (node.left == null && node.right == null) {
//            result.add(path.toString())
//        }
//        if (node.left != null) {
//            dfs(node.left, result, "$path-> ${node.left.`val`}")
//        }
//        if (node.right != null) {
//            dfs(node.right, result, "$path-> ${node.right.`val`}")
//        }
//    }

    private fun dfs(node: TreeNode?, result: LinkedList<String>, path: String?) {
        if (node == null) return
        val mPath = "$path-> ${node.`val`}"
        if (node.left == null && node.right == null) {
            result.add(mPath)
        }
        if (node.left != null) {
            dfs(node.left, result, mPath)
        }
        if (node.right != null) {
            dfs(node.right, result, mPath)
        }
    }


    fun binaryTreePaths(root: TreeNode?): List<String>? {
        val res: MutableList<String> = ArrayList()
        if (root == null) {
            return res
        }
        val paths: MutableList<Int> = ArrayList()
        traversal(root, paths, res)
        return res
    }

    private fun traversal(root: TreeNode, paths: MutableList<Int>, res: MutableList<String>) {
        paths.add(root.`val`)
        // 叶子结点
        if (root.left == null && root.right == null) {
            // 输出
            val sb = StringBuilder()
            for (i in 0 until paths.size - 1) {
                sb.append(paths[i]).append("->")
            }
            sb.append(paths[paths.size - 1])
            res.add(sb.toString())
            return
        }
        if (root.left != null) {
            traversal(root.left, paths, res)
            paths.removeAt(paths.size - 1) // 回溯
        }
        if (root.right != null) {
            traversal(root.right, paths, res)
            paths.removeAt(paths.size - 1) // 回溯
        }
    }
}