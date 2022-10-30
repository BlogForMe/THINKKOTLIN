package leetcode.backtrack.combination

import java.util.Stack

class LC77 {
    val path = ArrayList<Int>()
    val result = ArrayList<List<Int>>()
    fun combine(n: Int, k: Int): List<List<Int>> {
        backTracking(n, k, 1)
        return result
    }

    private fun backTracking(n: Int, k: Int, startIndex: Int) {
        if (path.size == k) {
            result.add(path.toMutableList())
            return
        }
        for (i in startIndex..n) {
            path.add(i)
            backTracking(n, k, startIndex + 1)
            path.removeLast()
        }
    }


//    fun combine(n: Int, k: Int): List<List<Int>> {
//        val result = ArrayList<ArrayList<Int>>()
//        for (i in 1..n) {
//            for (m in i+1 .. n){
//                println("i $i  m $m")
//                result.add(arrayListOf(i,m))
//            }
//        }
//        return result
//    }
}