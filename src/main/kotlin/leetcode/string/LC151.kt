package leetcode.string

import java.util.ArrayDeque
import java.util.Deque

class LC151 {

    /*   栈或双端队列解法
    *    1. 设置left , right指针，移动指针，类似移除两端的空格
    *    2. 从第一个元素开始遍历,添加到StringBuilder,直到遇到第一个空格，StringBuilder的数据加入队列,清空StringBuilder
    *    3. 直到最后一个加入队列
    *
    * if (s[left] != ' ') 中的' '是Ascii十进制32,单测中有验证
    * */

    fun reverseWords(s: String): String {
        var left = 0
        var right = s.length - 1
        while (s[left] == ' ') {
            left++
        }
        while (s[right] == ' ') {
            right--
        }

        val deque: Deque<String> = ArrayDeque()
        val sb = StringBuilder()
        for (i in left..right) {
            if (s[left] != ' ') {
                sb.append(s[left])
//            } else if (s[left] == ' ' && sb[sb.length - 1] != ' ') {
            } else if (s[left] == ' ' && sb.isNotEmpty()) { // 这里改成这样是因为加入 "the sky is blue" ， left==3走到了空格，
                deque.offerFirst(sb.toString())             //就初始化sb,然后left==4走到了s,如果两个空格，sb[sb.length - 1]就会越界
                sb.setLength(0)
            }
            left++
        }
        deque.offerFirst(sb.toString())
        return java.lang.String.join(" ", deque)
    }

    /**
     * 1. 去除空格，并且用StringBuilder组合
     * 2. 翻转整个StringBuilder
     * 3. 翻转StringBuilder中的单个字符
     */

    fun reverseWords2(s: String): String {
        val sb = deleteStartEndSpace(s)
        reverseStringBuilder(sb, 0, sb.length - 1)
        var wStart = 0
        var wEnd = 0
        while (wStart < sb.length) {
            if (sb.getOrElse(wEnd) { ' ' } == ' ') {
                reverseStringBuilder(sb, wStart, wEnd - 1)
                wStart = ++wEnd
            } else {
                wEnd++
            }
        }
        return sb.toString()
    }

    private fun deleteStartEndSpace(s: String): StringBuilder {
        var left = 0
        var right = s.length - 1
        while (s[left] == ' ') {
            left++
        }
        while (s[right] == ' ') {
            right--
        }
        val sb = StringBuilder()
        while (left <= right) { // 注意这里最右边的字符是需要添加的
            if (s[left] != ' ') {
                sb.append(s[left])
            } else if (s[left] == ' ' && s[left - 1] != ' ') { //不提前去掉空格，如果字符左边"  hello world  "有空格就会越界，
                sb.append(s[left])                            //而且StringBuilder右边空格也会添加空格，而且不好去掉
            }
            left++
        }
        return sb
    }

    private fun reverseStringBuilder(sb: StringBuilder, leftP: Int, rightP: Int) {
        var left = leftP
        var right = rightP
        while (left < right) {
            val temp = sb[left]
            sb.setCharAt(left, sb[right])
            sb.setCharAt(right, temp)
            left++
            right--
        }
    }

}