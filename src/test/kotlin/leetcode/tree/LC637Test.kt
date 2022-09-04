package leetcode.tree

import leetcode.ext.ConstructTree
import org.junit.Assert
import org.junit.Test

import org.junit.Assert.*

class LC637Test {

    @Test
    fun averageOfLevels() {
        val constructTree = ConstructTree.constructTree(arrayOf(3,9,20,null, null, 15, 7))
        val averageOfLevels = LC637().averageOfLevels(constructTree)
        println(averageOfLevels)
    }
}