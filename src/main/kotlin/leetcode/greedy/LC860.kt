package leetcode.greedy

class LC860 {
    fun lemonadeChange(bills: IntArray): Boolean {
        val map = HashMap<Int, Int>()
        for ((index, money) in bills.withIndex()) {
            if (money == 5) {
                map[5] = map.getOrDefault(5, 0).plus(1)
            } else if (money == 10) {
                map[5] = map.getOrDefault(5, 0) - 1
                map[10] = map.getOrDefault(10, 0).plus(1)
            } else { //for 20 rmb
                if (map.getOrDefault(10, 0) > 0 && map.getOrDefault(5, 0) > 0) { //at lease 10rmb 1  , 5rmb 1
                    map[10] = map.getOrDefault(10, 0) - 1
                    map[5] = map.getOrDefault(5, 0) - 1
                } else if (map.getOrDefault(5, 0) > 2) { // at least 3 * 5 rmb
                    map[5] = map.getOrDefault(5, 0) - 3
                } else {
                    return false
                }
            }
            println(" index $index    map5 ${map[5]} map10 ${map[10]} ")
            if (map.getOrDefault(5, 0) < 0 || map.getOrDefault(10, 0) < 0) {
                return false
            }
        }
        return true
    }
}