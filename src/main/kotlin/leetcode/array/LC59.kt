package leetcode.array

import printDimensionalArray


class LC59 {
    fun generateMatrix(n: Int): Array<IntArray> {
        var left = 0
        var top = 0
        var right = n - 1
        var bottom = n - 1
        var num = 1
        val target = n * n
        var arr = Array(n) { IntArray(n) }
        while (num <= target) {
            for (i in left..right) arr[top][i] = num++ //  从左到右 // 这里不是从0开始，是从left开始
            top++ // 上边向下收窄1
            for (i in top..bottom) arr[i][right] = num++ //  从上到下
            right-- // 右边收窄1
            for (i in right downTo left) arr[bottom][i] = num++ // 从右到左
            bottom--
            for (i in bottom downTo top){ // 从底到上
                arr[i][left] = num++
            }
            left++                            //收缩左边
        }
        return arr
    }

    fun printDimensionalArray1(n: Int) {
        var arr = Array(n) { IntArray(n) }
        arr.printDimensionalArray()
    }


}

