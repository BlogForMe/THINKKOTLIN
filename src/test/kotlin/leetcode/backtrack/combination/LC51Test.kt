package leetcode.backtrack.combination

import org.junit.Test

class LC51Test {
    @Test
    fun solveNQueensTest() {
        println(LC51().solveNQueens(4))
    }

    /**
     * for(int i=0, j=0; i < 6 && j < 6; i++, j+=2) {}
     */
    @Test
    fun twoDimentions() {
        for ((i, j) in (0..6).zip(0..6 step 2)) {
            println("values are: $i, $j")
        }
    }
}