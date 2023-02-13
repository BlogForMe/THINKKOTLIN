package leetcode.greedy

class LC134 {


    fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
        var totalSum = 0 //  所有路程需要的油量
        var currentSum = 0  // 当前位置开始所需要的油量
        var start = 0
        for (i in gas.indices) {
            totalSum += gas[i] - cost[i]
            currentSum += gas[i] - cost[i]
            if (currentSum < 0) { // 到i加油站需要油量 <0, 如果接下来 gas[i+1] - cost[i+1]还是<0,那么start ,currentSum 继续更新
                start = i + 1
                currentSum = 0
            }
        }
        if (totalSum < 0) {
            return -1
        }
        return start
    }


    fun canCompleteCircuit2(gas: IntArray, cost: IntArray): Int {
        var i = 0
        while (i < gas.size) {
            var j = i
            var currentSum = 0
            do {
                currentSum += gas[j] - cost[j]
                if (currentSum < 0) {
                    i = j + 1
                    break
                } else {
                    j = (j + 1) % gas.size
                }
                print("j $j  i $i")
                if (j % gas.size == i) {
                    return j
                }
            } while (j % gas.size != i)
        }
        return -1
    }


    fun canCompleteCircuit1(gas: IntArray, cost: IntArray): Int {
        for (i in gas.indices) {
            var balance = gas[i] - cost[i]
            var index = (i + 1) % gas.size
            while (balance > 0 && i != index) {  // 还有油的话，没走完一圈，继续走
                balance += (gas[index] - cost[index])
                index = (index + 1) % gas.size
            }
            if (balance >= 0 && (index == i)) {//走完一圈，返回下标
                return i
            }
        }
        return -1
    }
}