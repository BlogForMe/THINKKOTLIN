package leetcode.backtrack.combination

import org.junit.Assert
import org.junit.Test

import org.junit.Assert.*

class LC131Test {

    @Test
    fun isPalindromeNum() {
        assertEquals(true,LC131().isPalindromeNum("1221",0,4))
    }


    @Test
    fun partitionTest(){
        println(LC131().partition("aab"))
    }
}