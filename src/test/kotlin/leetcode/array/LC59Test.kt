package leetcode.array

import org.junit.Test
import printDimensionalArray

class LC59Test {

    @Test
    fun generateMatrix() {
        LC59().generateMatrix(3).printDimensionalArray()
    }

    @Test
    fun printDimensionalArray() {
        LC59().printDimensionalArray1(3)
    }
}