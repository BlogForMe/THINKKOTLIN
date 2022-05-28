package leetcode.hash

class LC202 {

    fun isHappy(n: Int): Boolean {
        val set = hashSetOf<Int>()
        var value = n
        while (!set.contains(value)) {
            if (value == 1) {
                return true
            }
            set.add(value)          // 把中间数加入hash表，为了判断是否有环的情况
            value = nextSquareSum(value)
        }
        return false
    }

    fun isHappy2(n: Int): Boolean {
        var slow = n
        var fast = n
        do {
            slow = nextSquareSum(slow) // 每个数据可以看作一个node, 然后设置快慢节点
            fast = nextSquareSum(fast)
            fast = nextSquareSum(fast)
            if (slow == 1 || fast == 1) {
                return true
            }
        } while (slow != fast)

        return false
    }

    private fun nextSquareSum(n: Int): Int {
        var sum = 0
        var num = n
        while (num > 0) {
            val balance = num % 10 //每次都获取余数
            sum += balance * balance
            num = (num / 10)       // 拿到上一位，然后求余
        }
        return sum
    }
}