import com.squareup.kotlinpoet.*
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.BlockJUnit4ClassRunner
import java.lang.Exception
import seven.ExcelFactory
import seven.config.Config
import java.io.File

/**
 * [Zhihu]https://www.zhihu.com/people/Sweets07
 * [Github]https://github.com/MatrixSeven
 * Created by seven on 2016/11/29.
 */
const val tacosPackage = "com.squareup.tacos"

@RunWith(BlockJUnit4ClassRunner::class)
class Multilingual {

    @Test
    @Throws(Exception::class)
    fun Test_01() {
        val filePath = System.getProperty("user.dir") + "/测试.xlsx"

        //CreateMapLoop
        val maps = ExcelFactory.getMaps(filePath) { it: Config ->
            it.vocSize(1999)
                .title(2)
                .content(3)
                .isLoopSheet(true)
        } //                .Filter(it -> it.get("在线人数").equals("43"))
            .CreateMapLoop()
        println(maps)
        //        //CreateMap
//        List<Map<String, String>> maps2 = ExcelFactory.getMaps(filePath, it -> it.vocSize(1999)
//                .title(2)
//                .content(3))
//                .Filter(it -> it.get("在线人数").equals("43"))
//                .CreateMap();
//        //Create Obj
//        List<B> create = ExcelFactory.<B>getBeans(B.class, filePath, it -> it.title(2)
//                .content(3)).Create();
//        System.out.println(create);
////        CreateObjLoop
//        Map<String, List<B>> stringListMap = ExcelFactory.<B>getBeans(B.class, filePath,
//                it -> it.isLoopSheet(true)
//                        .title(2)
//                        .content(3))
////                        .withConvert("name", f -> f.concat("111111111")))
//                .Process(a -> a.setAre(a.getAre().concat("|fuck")))
//                .CreateObjLoop();
//        System.out.println(stringListMap);
    }

    //    @Test
    //    public void Test_02() throws Exception {
    //        List<A> aa = new ArrayList<>();
    //        aa.add(new A("小明", 15, LocalDateTime.now()));
    //        aa.add(new A("小绿", 13, LocalDateTime.now()));
    //        aa.add(new A("唐山", 18, LocalDateTime.now()));
    //        aa.add(new A("狗东", 15, LocalDateTime.now()));
    //        aa.add(new A("百毒", 12, LocalDateTime.now()));
    //        ExcelFactory.saveExcel(aa, System.getProperty("user.dir").concat("/seven.xlsx"))
    //                //.Filter(a -> a.getA().equals("唐山"))
    //                //.Process(a -> a.setA(a.getA().concat("_seven")))
    //                .Sort(Comparator.comparing(A::getA))
    //                .Flush();
    //
    //
    //        List<Map<String, String>> m = new ArrayList<>();
    //        Map<String, String> mm = new HashMap<>();
    //        mm.put("姓名", "w");
    //        mm.put("年龄", "1");
    //        mm.put("性别", "w3");
    //        Map<String, String> mmm = new HashMap<>();
    //        mmm.put("姓名", "23");
    //        mmm.put("年龄", "w3asf2");
    //        mmm.put("性别", "w二3");
    //        m.add(mm);
    //        m.add(mmm);
    //        ExcelFactory.saveExcel(m, System.getProperty("user.dir").concat("/SaveMap_.xlsx"))
    //                .SetCellStyle("A", cellStyle -> cellStyle.setFillPattern(FillPatternType.DIAMONDS)
    //                        .setAlignment(HorizontalAlignment.RIGHT))
    //                .Flush();
    //
    //    }
    @Test
    @Throws(Exception::class)
    fun Test_03() {
        val maps = ExcelFactory.getMaps("/Users/m/Downloads/rfid_tag_termination_copywriting.xlsx") { it: Config ->
            it.title(1)
                .content(1)
                .isLoopSheet(true)
        }
            .CreateMapLoop()
        println(maps)
    }

    @Test
    @Throws(Exception::class)
    fun Test_04() {
        val filePath = System.getProperty("user.dir") + "/mulittest.xlsx"
        val fileWriteValVarable = File("/Users/m/Downloads/valss.txt")
        //CreateMapLoop
        val maps = ExcelFactory.getMaps(filePath) { it: Config ->
            it.vocSize(1999)
                .title(0)
                .content(1)
                .isLoopSheet(true)
        }
            .CreateMapLoop()
        val value: MutableCollection<MutableList<MutableMap<String, String>>> = maps.values
        value.forEach {
            it.forEach { eng ->
                fileWriteValVarable.printWriter().use { out ->
                    out.println(eng.get("English"))
                    println(eng.get("English"))
                }
            }
        }
    }


    @Test
    fun MyProject() {

        /**
         * read excel
         */
        val filePath = System.getProperty("user.dir") + "/mulittest.xlsx"
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
                addPropertyVAL.addProperty(
                    PropertySpec.builder(
                        KEY!!.replace(".", "_").uppercase(),
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
                    val i18n = I18n(
                        key = $uppercase,
                        localId = R.string.$lowercase
                    )
                   return getString(i18n)
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

    @Test
    fun itemString(){
        val source = FileSpec.get(
            tacosPackage,
            TypeSpec.classBuilder("StringItem")
                .build()
        )
        source.writeTo(System.out)

    }

}
