package leetcode.backtrack.combination

import org.junit.Test

import org.junit.Assert.*

class LC17Test {


    @Test
    fun AsciiTest() {
        val digits = "23"
        val c = digits[0] - '0' // 50 - 48
        println(digits[0].code) // ASCII是 50
        println('0'.code)       //ASCII是 48
        println((digits[0] - '0'))
    }

    @Test
    fun letterCombinations() {
        println(LC17().letterCombinations("23"))

    }
}