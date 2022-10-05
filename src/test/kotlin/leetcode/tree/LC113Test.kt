package leetcode.tree

import leetcode.ext.ConstructTree
import org.junit.Test

import org.junit.Assert.*

class LC113Test {

    @Test
    fun pathSum() {
       val root = ConstructTree.constructTree(arrayOf(5,4,8,11,null,13,4,7,2,null,null,5,1))
//        val pathSum = LC113().pathSum(root, 22)
//        val pathSum1 = LC113().pathSum1(root, 22)
        val pathSum1 = LC113().pathSum2(root, 22)
        println(pathSum1)
    }
}