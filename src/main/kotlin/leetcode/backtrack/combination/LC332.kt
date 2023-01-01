package leetcode.backtrack.combination

import java.util.TreeMap

class LC332 {
    //https://leetcode.cn/problems/reconstruct-itinerary/solutions/654811/java-bu-yong-ou-la-zhi-yong-hui-su-si-lu-4v83/
    val path = ArrayList<String>()
    fun findItinerary(tickets: List<List<String>>): List<String> {
        //1. list转成 from to 的结构
        //2. 回溯找到最合适的路径
        //3.  遇到的机场个数path ==航班数量+
        val hashMap = HashMap<String, TreeMap<String, Int>>()
        tickets.stream().forEach { ticket ->
            val from = ticket[0] // 出发地
            val to = ticket[1]  //目的地

            hashMap.putIfAbsent(from, TreeMap())
            val treeMap = hashMap[from] ?: TreeMap()  //获取出发地对应的容器TreeMap,如果之前没用过的出发地key,那么新建一个容器TreeMap
            treeMap[to] = treeMap.getOrDefault(to, 0) + 1 // 容器内，目的地的个数++
        }
        path.add("JFK") // 所有这些机票都属于一个从 JFK（肯尼迪国际机场）出发的先生，所以该行程必须从 JFK 开始。
        backTrack(hashMap, tickets.size)
        return path
    }

    private fun backTrack(hashMap: HashMap<String, TreeMap<String, Int>>, ticketSize: Int): Boolean {
        if (path.size == ticketSize + 1) {
            return true
        }
        // 1.根据path找到出发点,从hashmap根据出发点找到对应的 可能多个到达点
        // 2. 多个可能的目的地进行回溯.
        val recentTo = path[path.size - 1] //path.last() LeetCode build failed
        val toDestinations = hashMap[recentTo]
        if (toDestinations.isNullOrEmpty()) return false
        for (to in toDestinations) {// forEach也行, for习惯点
            if (to.value == 0) {
                continue
            }
            path.add(to.key)
            to.setValue(to.value - 1)
            if (backTrack(hashMap, ticketSize)) {
                return true
            }
            path.removeAt(path.size - 1)
            to.setValue(to.value + 1)
        }
        return false
    }

}