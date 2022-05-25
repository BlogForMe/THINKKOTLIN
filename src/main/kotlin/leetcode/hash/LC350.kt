package leetcode.hash

import java.util.Arrays

class LC350 {
    fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
        val ansArray = arrayListOf<Int>()
        val map1 = hashMapOf<Int, Int>()
        nums1.forEach {
            map1[it] = (map1[it] ?: 0).plus(1) // key是 nums1 数组的值，value是个数
        }
        val map2 = hashMapOf<Int, Int>()
        nums2.forEach {
            map2[it] = (map2[it] ?: 0).plus(1) //key是 nums2 数组的值，value是个数
        }
        val map3 = hashMapOf<Int, Int>()
        val keySet2 = map2.keys
        map1.entries.forEach { entry ->
            if (keySet2.contains(entry.key)) {
                if (entry.value < map2[entry.key]!!) { // 存在相同的值，比较数组的个数
                    map3[entry.key] = entry.value
                } else {
                    map3[entry.key] = map2[entry.key]!!      //较小的放给新的map
                }
            }
        }
        map3.entries.forEach { entry ->
            for (i in 0 until entry.value) { // entry.value是map的个数，然后添加的list
                ansArray.add(entry.key)
            }
        }
        return ansArray.toIntArray()
    }


    fun intersect2(nums1: IntArray, nums2: IntArray): IntArray {
        val ansArray = arrayListOf<Int>()
        val map = hashMapOf<Int, Int>()
        //可以判断数组长度
        nums1.forEach {
            map[it] = (map[it] ?: 0).plus(1) // key是 nums1 数组的值，value是个数
        }
        nums2.forEach {
            if ((map[it] ?: 0) > 0) {   // 判断是否存在相同的元素
                ansArray.add(it)        // 添加
                map[it] = map[it]!!.minus(1) // 原来的元素-1
            } else {
                map.remove(it)
            }
        }
        return ansArray.toIntArray()
    }


    fun intersect3(nums1: IntArray, nums2: IntArray): IntArray {
        Arrays.sort(nums1)
        Arrays.sort(nums2)
        val ansArray = arrayListOf<Int>()
        var index1 = 0
        var index2 = 0 // 排序后，设置两个指针，指向数组头节点

        while (index1 < nums1.size && index2 < nums2.size)
            if (nums1[index1] > nums2[index2]) { // 谁小，谁走
                index2++
            } else if (nums1[index1] < nums2[index2]) {
                index1++
            } else {                        //相等的情况，就添加到结果数组中
                ansArray.add(nums1[index1])
                index2++
                index1++
            }
        return ansArray.toIntArray()
    }

}


fun main() {
    val nums1 = intArrayOf(2, 2, 2)
    val map1 = hashMapOf<Int, Int>()
    nums1.forEach {
        val temp = map1[it] ?: 0
        val plus = temp.plus(1)
        map1[it] = plus
    }
    println(map1)
}
