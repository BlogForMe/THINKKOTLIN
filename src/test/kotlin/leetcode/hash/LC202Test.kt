package leetcode.hash

import org.junit.Test

import org.junit.Assert.*

class LC202Test {

    @Test
    fun isHappy() {
//        assertTrue(LC202().isHappy(19))
//        assertFalse(LC202().isHappy(2))

        assertTrue(LC202().isHappy2(19))
        assertFalse(LC202().isHappy2(2))
    }
}