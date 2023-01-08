import java.io.File

/**
 * 修改截图文件名称
 */
//const val FILE_NAME = "/Users/m/Documents/BLOG/source/_posts/CaptureApp/"
//const val FILE_NAME = "/Users/m/Desktop/"
const val FILE_NAME = "/Users/m/Documents/ENG/The Making of A Nation/"
//const val FILE_NAME = "/Users/m/Documents/BLOG/source/_posts/JVM/"

fun main() {
    val file = File(FILE_NAME)

//    var filterNames = file.list().filter {
//        it.contains("Screen Shot ")
//    }
//    println(filterNames)
//
//    filterNames.forEach {
//        val (l1, l2, l3, l4, l5) = it.split(" ")
//        println("$l1  $l2  $l3  $l4  $l5  ")
//        println("${l3}_${l5}_")
//        val newName = File(FILE_NAME + "${l3}_${l5}.png")
//        println("newName $newName")
//        println("oldName$FILE_NAME$it")
//
//        var flag = File(FILE_NAME + it).renameTo(newName)
//        println(flag)
//    }


    val filterNames = file.list()?.filter {
        it.contains("THE MAKING OF A NATION ")
    }

    filterNames?.forEach {
        val removePrefix = it.removePrefix("THE MAKING OF A NATION ")
        val file1 = File(FILE_NAME + it) //一开始命名失败，因为文件路径FILE_NAME没加上
        val file2 = File(FILE_NAME + removePrefix)
        if (file1.exists()) {
            val renameTo = file1.renameTo(file2)
            println("renameTo $renameTo")
        }

    }


}