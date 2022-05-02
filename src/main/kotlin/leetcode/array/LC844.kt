package leetcode.array

import java.util.Stack


class LC844 {
    fun backspaceCompare1(s: String, t: String): Boolean {
        val sStack = Stack<Char>()
        for (i in s.indices) {
            if (s[i] == '#') {
                if (sStack.isNotEmpty()) {
                    sStack.pop()
                }
            } else {
                sStack.push(s[i])
            }
        }

        val tStack = Stack<Char>()
        for (j in t.indices) {
            if (t[j] == '#') { // 复制还不如自己写，一开始写成s[i]
                if (tStack.isNotEmpty()) { //放上面if,tStack是空的情况，会把 #添加进来
                    tStack.pop()
                }
            } else {
                tStack.push(t[j])// 复制还不如自己写，一开始写成s[i]
            }
        }
        return sStack == tStack
    }


    fun backspaceCompare(s: String, t: String): Boolean {
        var i = s.length - 1
        var j = t.length - 1

        var skipS = 0
        var skipT = 0
        while (i >= 0 && j >= 0) {
            while (i >= 0) {
                if (s[i] == '#') { // 碰到这个先累计
                    skipS++
                    i--
                } else if (skipS > 0) { // 把#处理
                    skipS--
                    i--
                } else {
                    break
                }
            }

            while (j >= 0) {
                if (t[j] == '#') {
                    skipT++
                    j--
                } else if (skipT > 0) {
                    skipT--
                    j--
                } else {
                    break
                }
            }

            if (i >= 0 && j >= 0) { //上面有可能 i, j有可能到-1
                if (s[i] != t[j]) {
                    return false
                }
            } else if (i >= 0 || j >= 0) { // i ,j有多余的，也有问题
                return false
            }
            i--
            j--
        }
        return true
    }
}