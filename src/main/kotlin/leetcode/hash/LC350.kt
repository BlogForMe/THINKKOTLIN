package leetcode.hash

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
        map1.keys.forEach { key1 ->
            if (keySet2.contains(key1)) {
                if (map1[key1]!! < map2[key1]!!) { // 存在相同的值，比较数组的个数
                    map3[key1] = map1[key1]!!
                } else {
                    map3[key1] = map2[key1]!!      //较小的放给新的map
                }
            }
        }
        map3.entries.forEach {entry->
            for (i in 0 until entry.value) { // entry.value是map的个数，然后添加的list
                ansArray.add(entry.key)
            }
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
