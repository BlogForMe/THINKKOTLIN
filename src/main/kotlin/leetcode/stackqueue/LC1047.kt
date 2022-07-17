package leetcode.stackqueue

import java.util.*

class LC1047 {
    fun removeDuplicates(s: String): String {
        val stack = Stack<Char>()
        s.chars().forEach {
            if(!stack.empty()&&stack.peek()==it.toChar()){
                stack.pop()
            }else{
                stack.push(it.toChar())
            }
        }
        return stack.joinToString(separator = "")
    }
}