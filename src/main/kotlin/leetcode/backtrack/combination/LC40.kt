package leetcode.backtrack.combination

import java.util.Arrays

class LC40 {
    var sum = 0
    val path = ArrayList<Int>()
    val result = ArrayList<List<Int>>()

    fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
        Arrays.sort(candidates)
        println(candidates.joinToString())
        val used = BooleanArray(candidates.size)
//        backTrack(candidates, target, 0, used, 0)
        backTrack1(candidates, target, 0, used, 0)
        return result
    }

    private fun backTrack(candidates: IntArray, target: Int, startIndex: Int, used: BooleanArray, layer: Int) {
        if (sum > target) {
            return
        }
        if (sum == target) {
            result.add(path.toList())
            println(path)
            return
        }

        for (i in startIndex until candidates.size) {
            println("layer$layer i: $i candidates[i]: ${candidates[i]}   used: ${used[i]}")
            if (i > 0 && candidates[i] == candidates[i - 1] && !used[i - 1]) {
                println("continue ${candidates[i]}")
                continue
            }
            path.add(candidates[i])
            sum += candidates[i]
            used[i] = true
            println("path $path")
            backTrack(candidates, target, i + 1, used, layer + 1) // 经过日志排查后, i + 1之前写的是 startIndex +1, 第二层报错
            path.remove(candidates[i])
            println("path backTrack $path")
            sum -= candidates[i]
            used[i] = false
        }
    }

    private fun backTrack1(candidates: IntArray, target: Int, startIndex: Int, used: BooleanArray, layer: Int) {
        if (sum == target) {
            result.add(path.toList())
            println(path)
            return
        }

        for (i in startIndex until candidates.size) {
            if (sum + candidates[i] > target) { // 这样判断更好，因为是生序的数组，右边的枝没必要
                return
            }
            println("layer$layer i: $i candidates[i]: ${candidates[i]}   used: ${used[i]}")
            if (i > 0 && candidates[i] == candidates[i - 1] && !used[i - 1]) {
                println("continue ${candidates[i]}")
                continue
            }
            path.add(candidates[i])
            sum += candidates[i]
            used[i] = true
            println("path $path")
            backTrack1(candidates, target, i + 1, used, layer + 1) // 经过日志排查后, i + 1之前写的是 startIndex +1, 第二层报错
            path.remove(candidates[i])
            println("path backTrack $path")
            sum -= candidates[i]
            used[i] = false
        }
    }
}