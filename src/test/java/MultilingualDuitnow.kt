import com.squareup.kotlinpoet.*
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.BlockJUnit4ClassRunner
import seven.ExcelFactory
import seven.config.Config

/**
 * [Zhihu]https://www.zhihu.com/people/Sweets07
 * [Github]https://github.com/MatrixSeven
 * Created by seven on 2f016/11/29.
 */
const val tacosPackage1 = "com.squareup.tacos"

@RunWith(BlockJUnit4ClassRunner::class)
class MultilingualDuitnow {



    @Test
    fun MyDuitNowProject() {

        /**
         * read excel
         */
        val filePath = System.getProperty("user.dir") + "/03082022_DuitNowdr.xlsx"
        //CreateMapLoop
        val maps = ExcelFactory.getMaps(filePath) { it: Config ->
            it.vocSize(1999)
                .title(0)
                .content(1)
                .isLoopSheet(true)
        }
            .CreateMapLoop()


        /**
         * Generate method
         */

        val MethodClass = TypeSpec.classBuilder("MethodClass")



        /**
         * 常量
         */
        val addPropertyVAL = TypeSpec.classBuilder("Taco")


        val value: MutableCollection<MutableList<MutableMap<String, String>>> = maps.values


        /**
         * item默认语言
         */

        val sbItemEnglish = StringBuilder()
        value.forEach {
            it.forEach { eng ->
                /**
                 * 常量
                 */
                val KEY = eng["Key"]
                if (KEY.isNullOrEmpty()) return@forEach
                addPropertyVAL.addProperty(
                    PropertySpec.builder(
                        KEY.replace(".", "_").uppercase(),
                        String::class,
                        KModifier.PRIVATE,
                        KModifier.CONST
                    )
                        .initializer("%S", KEY)
                        .build()
                )

                /**
                 *方法
                 */

                val methodName = StringBuilder("get")
                KEY.split(".").forEach {
                    methodName.append(it.replaceFirstChar { it.uppercase() })
                }

                val lowercase = KEY.replace(".", "_").lowercase()
                val uppercase = KEY.replace(".", "_").uppercase()

                val stateMent1 = """
                   return $uppercase translate R.string.$lowercase
        """.trimIndent()


                MethodClass
                    .addFunction(
                        FunSpec.builder(methodName.toString())
                            .returns(String::class)
                            .addStatement(stateMent1)
                            .build()
                    )

                /**
                 * 默认语言
                 */
               val itemEnglish = """
                 <string name="$lowercase">${eng["English"]}</string>
                 
                """.trimIndent()
                sbItemEnglish.append(itemEnglish)
            }
        }


        val source = FileSpec.get(
            tacosPackage,
            addPropertyVAL.build()
        )
        source.writeTo(System.out) // 属性


        val sourceMethod = FileSpec.get(
            tacosPackage,
            MethodClass
                .build()
        )
        sourceMethod.writeTo(System.out)

        println("\n $sbItemEnglish \n") //默认英语
    }


    @Test
    fun strings() {
        val tacosPackage = "com.squareup.tacos"
        val datass ="标题"
        val stateMent1 = """
             val i18n = I18n( 
                       key = $datass)
        """.trimIndent()

        val source = FileSpec.get(
            tacosPackage,
            TypeSpec.classBuilder("Taco")
                .addFunction(
                    FunSpec.builder("strings")
                        .returns(String::class)
                        .addStatement(stateMent1)
                        .build()
                )
                .build()
        )
        source.writeTo(System.out)
    }


}
