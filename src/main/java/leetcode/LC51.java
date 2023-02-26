package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class LC51 {
    List<List<String>> result = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        //1. 初始化棋盘放上.
        char[][] chessBoard = new char[n][n];
        for (char[] c : chessBoard) {
            Arrays.fill(c, '.');
        }
        // 2. 开始放Queue,首先从行开始，一行一行回溯的放， 然后每一行开始从第1列开始。
        // 3. 每次新的一行开始放Queue时，要考虑当前位置列的 前面的列有没有Queue,
        // 当前位置的左边45度和135度有没有Queue,对于当前行和后面的行和斜对角不用考虑，因为每一行只有一个Queue,后面的行更是没有。
        //4 。只有能放下，才会放后续的，然后进行回溯.
        //5. 当放下的Queue时最后一行n时，递归结束，开始收集结果。
        backTrack(n, 0, chessBoard);
        return result;
    }

    private void backTrack(int n, int row, char[][] chessBoard) {
        if (n == row) {
            result.add(Array2List(chessBoard));
            return;
        }
        for (int column = 0; column < n; ++column) {
            if (isValid(row, column, chessBoard, n)) { // row,column待放入Queue的位置
                chessBoard[row][column] = 'Q';
                backTrack(n, row + 1, chessBoard);
                chessBoard[row][column] = '.';
            }
        }
    }

    private boolean isValid(int pRow, int pColumn, char[][] chessBoard, int n) {
        for (int i = 0; i < pRow; ++i) { //列
            if (chessBoard[i][pColumn] == 'Q') {
                return false;
            }
        }
        for (int x = pRow - 1, y = pColumn - 1; x >= 0 && y >= 0; x--, y--) { //左上角 首次==边界错了
            if (chessBoard[x][y] == 'Q') {
                return false;
            }
        }
        for (int x = pRow - 1, y = pColumn + 1; x >= 0 && y <= n - 1; x--, y++) {//右上角  首次==,n-1边界错了 ,y < n - 1一开始写成这样，找了半天
            if (chessBoard[x][y] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public List Array2List(char[][] chessboard) {
        List<String> list = new ArrayList<>();

        for (char[] c : chessboard) {
            list.add(String.copyValueOf(c));
        }
        return list;
    }
}
