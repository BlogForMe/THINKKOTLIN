package leetcode.greedy

import java.util.*

class LC455 {
    fun findContentChildren(g: IntArray, s: IntArray): Int {
        if (s.isEmpty()) return 0
        Arrays.sort(g)  // 写了s.isEmpty()， 一开始忘了加这个排序
        Arrays.sort(s)
        var pg = 0
        var ps = 0
        var count = 0
        while (pg < g.size && ps < s.size) { // 控制边界
            if (s[ps] >= g[pg]) {       //饼干满足孩子的胃口大小.
                count++
                pg++
                ps++
            } else {
                ps++    //饼干不满足孩子的胃口大小，饼干数组指针往右走.
            }
        }
        return count
    }
}