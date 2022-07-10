package leetcode.string

import java.util.*

class LC20 {
    fun isValid(s: String): Boolean {
        val mapOf = mapOf('(' to ')', '{' to '}', '[' to ']')
        val stack = Stack<Char>()
        s.chars().forEach {
            if (!stack.empty() && mapOf[stack.peek()] == it.toChar()) { //stack 为空 取出会抛出异常, mapOf应该取左边的符号也就是stack里的
                stack.pop()
            } else {
                stack.push(it.toChar())
            }
        }
        return stack.empty()
    }
}


fun main() {
    "()[]{}".chars().forEach {
        println((it.toChar()))
    }
}