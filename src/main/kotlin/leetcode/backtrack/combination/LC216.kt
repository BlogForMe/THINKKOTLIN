package leetcode.backtrack.combination

class LC216 {
    private val result = ArrayList<List<Int>>()
    private var sum: Int = 0 //集合的和
    private val pathList = ArrayList<Int>() // 集合
    fun combinationSum3(k: Int, n: Int): List<List<Int>> {
        blockTracking(k, n, 1)
        println(result)
        return result
    }

//    private fun blockTracking(k: Int, n: Int, startIndex: Int) {
//        if (sum == n && pathList.size == k) {
//            result.add(pathList.toMutableList())
//            return
//        }
//        for (i in startIndex..9) {
//            sum += i
//            pathList.add(i)
//            blockTracking(k, n, i + 1)
//            sum -= i
//            pathList.remove(i)
//        }
//    }

    private fun blockTracking(k: Int, n: Int, startIndex: Int) {
        if (sum > n) {
            return //sum > n 直接返回，随想录的解法，这样更好.
        }
        if (pathList.size == k) {
            if (sum == n) {
                result.add(pathList.toMutableList())
            }
            return
        }
        for (i in startIndex..(9 - (k - pathList.size) + 1)) {

            sum += i
            pathList.add(i)
            blockTracking(k, n, i + 1)
            sum -= i
            pathList.remove(i)
        }
    }
}