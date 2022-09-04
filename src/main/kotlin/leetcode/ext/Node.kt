package leetcode.ext

class Node(var `val`: Int) {
    var children: List<Node?> = listOf()
    var left: Node? = null
    var right: Node? = null
    var next: Node? = null
}