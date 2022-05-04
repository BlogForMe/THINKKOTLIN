package leetcode.tool

class ListNode() {
    var `val`: Int = 0
    var next: ListNode? = null

    constructor(x: Int) : this() {
        `val` = x
    }

    // 链表节点的构造函数
    // 使用arr为参数，创建一个链表，当前的ListNode为链表头节点
    constructor(arr: IntArray?) : this() {
        require(!(arr == null || arr.isEmpty())) { "arr can not be empty" }
        `val` = arr[0]
        var cur: ListNode? = this
        for (i in 1 until arr.size) {
            cur!!.next = ListNode(arr[i])
            cur = cur.next
        }
    }

    //以当前节点为头节点的链表信息字符串 方便查看
    override fun toString(): String {
        val res = StringBuilder()
        var cur: ListNode? = this
        while (cur != null) {
            res.append(cur.`val`.toString() + "->")
            cur = cur.next
        }
        res.append("NULL")
        return res.toString()
    }
}