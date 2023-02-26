package leetcode.tree

import java.io.Serializable
import java.util.LinkedList
import java.util.Stack
import leetcode.ext.TreeNode

class LC94 {
    fun inorderTraversal(root: TreeNode?): List<Int> {
        val linkedList = LinkedList<Int>()
        orderRecursive(root, linkedList)
        return linkedList
    }

    private fun orderRecursive(node: TreeNode?, linkedList: LinkedList<Int>) {
        if (node == null) return
        orderRecursive(node.left, linkedList)
        linkedList.add(node.`val`)
        orderRecursive(node.right, linkedList)
    }


    fun inorderTraversal1(root: TreeNode?): List<Int> {
        val linkedList = LinkedList<Int>()
        if (root == null) return linkedList
        val stack = Stack<TreeNode>()
        var node = root
        while (node != null || !stack.empty()) { //node != null 第一次可以进来
            if (node != null) {
                stack.push(node)
                node = node.left
            } else {
                val resultNode = stack.pop()
                linkedList.add(resultNode.`val`)
                node = resultNode.right
            }
        }
        return linkedList
    }

}


private fun <K, V> mapOf(vararg pairs: PairN<K, V>): Map<K, V> =
    if (pairs.size > 0) pairs.toMapN(LinkedHashMap(pairs.size)) else emptyMap()


private fun <K, V, M : MutableMap<in K, in V>> Array<out PairN<K, V>>.toMapN(destination: M): M =
    destination.apply { putAll(this@toMapN) }

private fun <K, V> MutableMap<in K, in V>.putAll(pairs: Array<out PairN<K, V>>): Unit {
    for ((key, value) in pairs) {
        put(key, value)
    }
}

private data class PairN<in A, in B>(
    val first: @UnsafeVariance A,
    val second: @UnsafeVariance B
) : Serializable {

    /**
     * Returns string representation of the [PairN] including its [first] and [second] values.
     */
    public override fun toString(): String = "($first, $second)"
}

