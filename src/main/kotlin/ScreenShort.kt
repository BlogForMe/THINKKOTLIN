import java.io.File

/**
 * 修改截图文件名称
 */
//const val FILE_NAME = "/Users/m/Documents/workspace/THINKJAVA/THINKKOTLIN/src/image/"
const val FILE_NAME = "/Users/m/Desktop/"

fun main() {
    val file = File(FILE_NAME)
    var filterNames = file.list().filter {
        it.contains("Screen Shot ")
    }
    println(filterNames)

    filterNames.forEach{
        val (l1,l2,l3,l4,l5) = it.split(" ")
        println("$l1  $l2  $l3  $l4  $l5  ")
        println("${l3}_${l5}_")
        val newName=File(FILE_NAME+"${l3}_${l5}_.png")
        println("newName $newName")
//    var flag = File("/Users/m/Desktop/$filterName").renameTo(newName)
//    println(flag)
        println("oldName"+FILE_NAME+it)

        var flag = File(FILE_NAME+it).renameTo(newName)
        println(flag)

    }



}