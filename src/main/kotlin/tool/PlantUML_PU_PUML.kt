import java.io.File

/**
 * 修改截图文件名称
 */

fun main() {
    val FILE_NAME = "/Users/m/Downloads/PlantUML-Samples-master/时序图/"

    val file = File(FILE_NAME)
    var filterNames = file.list().filter {
        it.endsWith(".pu")
    }
//    println(filterNames)

    filterNames.forEach {
        val (l1, l2) = it.split(".")
//        println("$l1  $l2 ")
        val newName = File("$FILE_NAME$l1.${l2}ml")
        println("newName $newName")
        var flag = File(FILE_NAME + it).renameTo(newName)
//        println(flag)


    }
}

