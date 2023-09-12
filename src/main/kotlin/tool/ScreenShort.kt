import java.io.File

/**
 * 修改截图文件名称
 */
//const val FILE_NAME = "/Users/m/Documents/BLOG/source/_posts/CaptureApp/"
const val FILE_NAME = "/Users/m/Desktop/"
//const val FILE_NAME = "/Users/m/Documents/ENG/The Making of A Nation/"
//const val FILE_NAME = "/Users/m/Documents/BLOG/source/_posts/JVM/"

fun main() {
    val file = File(FILE_NAME)
    val listFile = file.list()
    val filterNames = listFile?.filter {
        it.contains("Screenshot")
    }
    filterNames?.forEach {
        val newName = File(it.replace("\\s|\\.", "-"))
        val flag = File(FILE_NAME + it).renameTo(newName)
        println(flag)
    }



}