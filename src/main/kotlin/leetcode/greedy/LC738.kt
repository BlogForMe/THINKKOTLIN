package leetcode.greedy

import java.lang.StringBuilder

class LC738 {

//    fun monotoneIncreasingDigits(n: Int): Int {
//        val arrStr = n.toString().toCharArray()
//        for (i in arrStr.size - 1 downTo 1) {
//            if (arrStr[i - 1] > arrStr[i]) {
//                arrStr[i] = '9'
//                arrStr[i - 1] = arrStr[i - 1].toInt().minus(1).toChar() // 语法报错，感觉也没啥问题
//            }
//        }
//        return String(arrStr).toInt()
//    }

    fun monotoneIncreasingDigits(n: Int): Int {
        val arrStr = n.toString().toCharArray()
        var position = arrStr.size //初始位置不能是  arrStr.size - 1 ，否则最后一位都会变成 '9'
        for (i in arrStr.size - 1 downTo 1) {
            if (arrStr[i - 1] > arrStr[i]) {
                arrStr[i - 1] = arrStr[i - 1].toInt().minus(1).toChar() // digitToInt leetcode跑不了
                position = i // 找到-1 的位置，后面的位都变成9
            }
        }
        for (i in position until arrStr.size) {
            arrStr[i] = '9'
        }
        return String(arrStr).toInt()
    }


}