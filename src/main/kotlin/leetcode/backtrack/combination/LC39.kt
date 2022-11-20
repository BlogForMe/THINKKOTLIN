package leetcode.backtrack.combination

import java.util.*
import kotlin.collections.ArrayList

class LC39 {
    var sum = 0
    private val path = ArrayList<Int>()
    private val result = ArrayList<List<Int>>()
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
//        backTrack1(candidates.toList(), target)
        Arrays.sort(candidates) //剪枝前需要排序
        backTrack(candidates.toList(), target, 0)
        return result
    }

    private fun backTrack1(candidates: List<Int>, target: Int) {
        if (sum > target) {
            return
        }
        if (sum == target) {
            result.add(path.toList())
            return
        }
        for ((i, item) in candidates.withIndex()) {
            path.add(item)
            sum += item
            backTrack1(candidates.toMutableList().subList(i, candidates.size), target)
            path.remove(item)
            sum -= item
        }
    }

//    private fun backTrack(candidates: List<Int>, target: Int, startIndex: Int) {
//        if (sum > target) {
//            return
//        }
//        if (sum == target) {
//            result.add(path.toList())
//            return
//        }
//        for (i in startIndex until candidates.size) {
//            path.add(candidates[i])
//            sum += candidates[i]
//            backTrack(candidates, target, i)
//            path.remove(candidates[i])
//            sum -= candidates[i]
//        }
//    }


    private fun backTrack(candidates: List<Int>, target: Int, startIndex: Int) {
        if (sum > target) {
            return
        }
        if (sum == target) {
            result.add(path.toList())
            return
        }
        for (i in startIndex until candidates.size) {
            if (sum + candidates[i] > target) { //  剪枝操作
                return
            }
            path.add(candidates[i])
            sum += candidates[i]
            backTrack(candidates, target, i)
            path.remove(candidates[i])
            sum -= candidates[i]
        }
    }
}