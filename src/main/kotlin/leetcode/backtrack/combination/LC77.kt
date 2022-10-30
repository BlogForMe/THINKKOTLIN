package leetcode.backtrack.combination

class LC77 {
    val path = ArrayList<Int>()
    val result = ArrayList<List<Int>>()
    fun combine(n: Int, k: Int): List<List<Int>> {
        backTracking1(n, k, 1)
        return result
    }
    //剪枝操作
    private fun backTracking1(n: Int, k: Int, startIndex: Int) {
        if (path.size == k) {
            result.add(path.toMutableList())
            return
        }
        for (i in startIndex..(n - (k - path.size) + 1)) {
            path.add(i)
            backTracking1(n, k, i + 1) // 这里一开始用的是 startIndex+1
            path.remove(i)
        }
    }

    private fun backTracking(n: Int, k: Int, startIndex: Int) {
        if (path.size == k) {
            result.add(path.toMutableList())
            return
        }
        for (i in startIndex..n) {
            path.add(i)
            backTracking(n, k, i + 1) // 这里一开始用的是 startIndex+1
            path.remove(i)
        }
    }




//    fun combine(n: Int, k: Int): List<List<Int>> {
//        val result = ArrayList<ArrayList<Int>>()
//        for (i in 1..n) {
//            for (m in i+1 .. n){
//                println("i $i  m $m")
//                result.add(arrayListOf(i,m))
//            }
//        }
//        return result
//    }
}