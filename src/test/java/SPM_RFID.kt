import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.TypeSpec
import org.junit.Test
import seven.ExcelFactory
import seven.config.Config

class SPM_RFID {

    @Test
    fun spmTransportation() {

        /**
         * read excel
         */
        val filePath = System.getProperty("user.dir") + "/file/SPM_transportation.xlsx"
        //CreateMapLoop
        val maps = ExcelFactory.getMaps(filePath) { it: Config ->
            it.vocSize(1999)
                .title(0) // 标题第0行开始
                .content(1) // 内容第1行开始
                .isLoopSheet(true)
        }
            .CreateMapLoop()


        /**
         * Generate method
         */

        val MethodClass = TypeSpec.classBuilder("MethodClass")


        val value: MutableCollection<MutableList<MutableMap<String, String>>> = maps.values
        value.forEach {
            it.forEach { eng ->
                val SPMID = eng["SPMID"]
                val EVENT = eng["EVENT"]


                val stateMent1 = "${getSpmMethod(EVENT)}(spmId = \"$SPMID\")"

                /**
                 *方法
                 */

                val methodName = StringBuilder("on")
                methodName.append(SPMID?.split(".")?.last()).append(EVENT)

                MethodClass
                    .addFunction(
                        FunSpec.builder(methodName.toString())
                            .addStatement(stateMent1)
                            .build()
                    )
            }
        }
        val sourceMethod = FileSpec.get(
            tacosPackage,
            MethodClass
                .build()
        )
        sourceMethod.writeTo(System.out)

    }

    private fun getSpmMethod(event: String?): String {
        return when (event) {
            "Exposure" -> "spmExpose"
            else -> "spmClick"
        }
    }


    @Test
    fun noRfidUser() {
        val last = "TNGAPP.RFID.NonRfidUser".split(".").last()
        println(last)
    }
}