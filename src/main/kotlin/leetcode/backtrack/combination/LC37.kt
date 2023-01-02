package leetcode.backtrack.combination

class LC37 {


    // 1.先行 后列的顺序，找到字符位 '.'的空格，填入 1 - 9 的数字
    // 2.填入后，开始回溯
    // 3.填入空格的时候，如果没有返回true,if就返回false
    // 4. 如果全部填满了都没返回true,此时说明已经到了叶子节点，直接返回true.
    fun solveSudoku(board: Array<CharArray>): Unit {
        backTrack(board)
    }

    private fun backTrack(board: Array<CharArray>): Boolean {
        for (i in board.indices) {
            for (j in board[0].indices) {
                if (board[i][j] == '.') {
                    for (k in '1'..'9') {
                        if (isValid(i, j, k, board)) {
                            board[i][j] = k
                            if (backTrack(board)) {
                                return true
                            }
                            board[i][j] = '.'
                        }
                        return false
                    }
                }
            }
        }
        return true
    }

    private fun isValid(row: Int, column: Int, k: Char, board: Array<CharArray>): Boolean {
        for (i in board[0].indices) { //一开始不理解很多解法包括，随想录用的是9,这样如果不是9*9就有问题了,原来题目给的就是9*9的方格
            if (board[row][i] == k) {
                return false
            }
        }
        for (i in board.indices) {
            if (board[i][column] == k) {
                return false
            }
        }

        val startRow = (row / 3) * 3
        val startColumn = (column / 3) * 3
        for (i in startRow until (startRow + 3)) {
            for (j in startColumn until startColumn + 3) {
                if (board[i][j] == k) {
                    return false
                }
            }
        }
        return true
    }

}