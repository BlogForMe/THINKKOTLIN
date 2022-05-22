package leetcode.hash

import org.junit.Test

import org.junit.Assert.*

class LC383Test {

    @Test
    fun canConstruct() {
        assertFalse(LC383().canConstruct("a", "b"))
        assertFalse(LC383().canConstruct("aa", "ab"))
        assert(LC383().canConstruct("aa", "aab"))

        assertFalse(LC383().canConstruct02("a", "b"))
        assertFalse(LC383().canConstruct02("aa", "ab"))
        assert(LC383().canConstruct02("aa", "aab"))

        var i = 0
        i = ++i
        println(i)

    }
}