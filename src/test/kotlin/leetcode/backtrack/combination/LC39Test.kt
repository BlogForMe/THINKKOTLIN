package leetcode.backtrack.combination

import org.junit.Test

import org.junit.Assert.*
import java.util.Arrays

class LC39Test {

    @Test
    fun combinationSum() {
        println(LC39().combinationSum(intArrayOf(2, 3, 6, 7), 7))
        println(LC39().combinationSum(intArrayOf(2,3,5), 8))
        println(LC39().combinationSum(intArrayOf(2), 1))

    }

    @Test
    fun cutIntArray() {
        val candidates = intArrayOf(2, 3, 6, 7)
        val listOf = candidates.toList()
        println(listOf.joinToString())
        println(listOf.subList(1, listOf.size).joinToString())
    }
}