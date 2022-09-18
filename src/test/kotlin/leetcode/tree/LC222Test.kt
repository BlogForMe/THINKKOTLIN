package leetcode.tree

import leetcode.ext.ConstructTree
import org.junit.Test

import org.junit.Assert.*

class LC222Test {

    @Test
    fun countNodes() {
//        assertEquals(6,LC222().countNodes(ConstructTree.constructTree(arrayOf(1,2,3,4,5,6))))

//        assertEquals(1,LC222().countNodes(ConstructTree.constructTree(arrayOf(1))))
        assertEquals(3,LC222().countNodes(ConstructTree.constructTree(arrayOf(1,2,3))))
        assertEquals(6,LC222().countNodes(ConstructTree.constructTree(arrayOf(1,2,3,4,5,6))))

//        assertEquals(6,LC222().countNodes1(ConstructTree.constructTree(arrayOf(1,2,3,4,5,6))))
    }


    @Test
    fun shlTest(){
        println(2 shl -1)
        println(2 shl 0)
        println(2 shl 1)
    }
}