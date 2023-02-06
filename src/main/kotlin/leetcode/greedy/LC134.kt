package leetcode.greedy

class LC134 {
    fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
        for (i in gas.indices) {
            var balance = 0
            var index = i
            while (balance > 0 && i != index) {
                balance += (gas[index] - cost[index])
                index = (index + 1) % gas.size
            }
        }
    }
}