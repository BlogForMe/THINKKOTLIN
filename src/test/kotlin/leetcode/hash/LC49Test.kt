package leetcode.hash

import org.junit.Test

import org.junit.Assert.*
import java.util.Arrays

class LC49Test {

    @Test
    fun groupAnagrams() {
        val groupAnagrams = LC49().groupAnagrams(arrayOf("eat", "tea", "tan", "ate", "nat", "bat"))
        println()
    }

    @Test
    fun checkListValues(){
        val ans = HashMap<Int,List<String>>()
        ans[1] = arrayListOf("a","b")
        ans[2] = arrayListOf("c","d")
        ans[3] = arrayListOf("e","f")
        val arrayList = ArrayList(ans.values)
        println()
    }


    @Test
    fun stringValueOf(){
        val s = "jond"
        val ca = s.toCharArray()
        Arrays.sort(ca)
        String(ca)
    }
}