//package tool
//
//import com.alibaba.excel.EasyExcel
//import com.alibaba.excel.read.listener.PageReadListener
//import jdk.nashorn.internal.ir.annotations.Ignore
//import org.junit.jupiter.api.Test
//import java.io.File
//
//import java.text.NumberFormat
//
///**
// * 在test里面，不在这里
// */
//
//
//fun main() {
//
//    /**
//     * 读的常见写法
//     *
//     * @author Jiaju Zhuang
//     */
//    /**
//     * 读的常见写法
//     *
//     * @author Jiaju Zhuang
//     */
//    @Ignore
////    @Slf4j
//    class ReadTest {
//        /**
//         * 最简单的读
//         *
//         *
//         * 1. 创建excel对应的实体对象 参照[DemoData]
//         *
//         *
//         * 2. 由于默认一行行的读取excel，所以需要创建excel一行一行的回调监听器，参照[DemoDataListener]
//         *
//         *
//         * 3. 直接读即可
//         */
//        @Test
//        fun simpleRead() {
//            // 写法1：JDK8+ ,不用额外写一个DemoDataListener
//            // since: 3.0.0-beta1
//            var fileName: String = TestFileUtil.getPath() + "demo" + File.separator + "demo.xlsx"
//            // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
//            // 这里每次会读取3000条数据 然后返回过来 直接调用使用数据就行
//            EasyExcel.read(fileName,
//                DemoData::class.java, PageReadListener<DemoData> { dataList ->
//                    for (demoData in dataList) {
//                        log.info("读取到一条数据{}", JSON.toJSONString(demoData))
//                    }
//                }).sheet().doRead()
//
//            // 写法2：
//            // 匿名内部类 不用额外写一个DemoDataListener
//            fileName = TestFileUtil.getPath() + "demo" + File.separator + "demo.xlsx"
//            // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
//            EasyExcel.read(fileName, DemoData::class.java, object : ReadListener<DemoData?>() {
//                /**
//                 * 单次缓存的数据量
//                 */
//                static
//                val BATCH_COUNT = 100
//
//                /**
//                 * 临时存储
//                 */
//                private var cachedDataList: MutableList<DemoData> = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT)
//                operator fun invoke(data: DemoData, context: AnalysisContext?) {
//                    cachedDataList.add(data)
//                    if (cachedDataList.size >= BATCH_COUNT) {
//                        saveData()
//                        // 存储完成清理 list
//                        cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT)
//                    }
//                }
//
//                fun doAfterAllAnalysed(context: AnalysisContext?) {
//                    saveData()
//                }
//
//                /**
//                 * 加上存储数据库
//                 */
//                private fun saveData() {
//                    log.info("{}条数据，开始存储数据库！", cachedDataList.size)
//                    log.info("存储数据库成功！")
//                }
//            }).sheet().doRead()
//
//            // 有个很重要的点 DemoDataListener 不能被spring管理，要每次读取excel都要new,然后里面用到spring可以构造方法传进去
//            // 写法3：
//            fileName = TestFileUtil.getPath() + "demo" + File.separator + "demo.xlsx"
//            // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
//            EasyExcel.read(fileName, DemoData::class.java, DemoDataListener()).sheet().doRead()
//
//            // 写法4：
//            fileName = TestFileUtil.getPath() + "demo" + File.separator + "demo.xlsx"
//            // 一个文件一个reader
//            var excelReader: ExcelReader? = null
//            try {
//                excelReader = EasyExcel.read(fileName, DemoData::class.java, DemoDataListener()).build()
//                // 构建一个sheet 这里可以指定名字或者no
//                val readSheet: ReadSheet = EasyExcel.readSheet(0).build()
//                // 读取一个sheet
//                excelReader.read(readSheet)
//            } finally {
//                if (excelReader != null) {
//                    // 这里千万别忘记关闭，读的时候会创建临时文件，到时磁盘会崩的
//                    excelReader.finish()
//                }
//            }
//        }
//
//        /**
//         * 指定列的下标或者列名
//         *
//         *
//         *
//         * 1. 创建excel对应的实体对象,并使用[ExcelProperty]注解. 参照[IndexOrNameData]
//         *
//         *
//         * 2. 由于默认一行行的读取excel，所以需要创建excel一行一行的回调监听器，参照[IndexOrNameDataListener]
//         *
//         *
//         * 3. 直接读即可
//         */
//        @Test
//        fun indexOrNameRead() {
//            val fileName: String = TestFileUtil.getPath() + "demo" + File.separator + "demo.xlsx"
//            // 这里默认读取第一个sheet
//            EasyExcel.read(fileName, IndexOrNameData::class.java, IndexOrNameDataListener()).sheet().doRead()
//        }
//
//        /**
//         * 读多个或者全部sheet,这里注意一个sheet不能读取多次，多次读取需要重新读取文件
//         *
//         *
//         * 1. 创建excel对应的实体对象 参照[DemoData]
//         *
//         *
//         * 2. 由于默认一行行的读取excel，所以需要创建excel一行一行的回调监听器，参照[DemoDataListener]
//         *
//         *
//         * 3. 直接读即可
//         */
//        @Test
//        fun repeatedRead() {
//            var fileName: String = TestFileUtil.getPath() + "demo" + File.separator + "demo.xlsx"
//            // 读取全部sheet
//            // 这里需要注意 DemoDataListener的doAfterAllAnalysed 会在每个sheet读取完毕后调用一次。然后所有sheet都会往同一个DemoDataListener里面写
//            EasyExcel.read(fileName, DemoData::class.java, DemoDataListener()).doReadAll()
//
//            // 读取部分sheet
//            fileName = TestFileUtil.getPath() + "demo" + File.separator + "demo.xlsx"
//            var excelReader: ExcelReader? = null
//            try {
//                excelReader = EasyExcel.read(fileName).build()
//
//                // 这里为了简单 所以注册了 同样的head 和Listener 自己使用功能必须不同的Listener
//                val readSheet1: ReadSheet =
//                    EasyExcel.readSheet(0).head(DemoData::class.java).registerReadListener(DemoDataListener()).build()
//                val readSheet2: ReadSheet =
//                    EasyExcel.readSheet(1).head(DemoData::class.java).registerReadListener(DemoDataListener()).build()
//                // 这里注意 一定要把sheet1 sheet2 一起传进去，不然有个问题就是03版的excel 会读取多次，浪费性能
//                excelReader.read(readSheet1, readSheet2)
//            } finally {
//                if (excelReader != null) {
//                    // 这里千万别忘记关闭，读的时候会创建临时文件，到时磁盘会崩的
//                    excelReader.finish()
//                }
//            }
//        }
//
//        /**
//         * 日期、数字或者自定义格式转换
//         *
//         *
//         * 默认读的转换器[DefaultConverterLoader.loadDefaultReadConverter]
//         *
//         *
//         * 1. 创建excel对应的实体对象 参照[ConverterData].里面可以使用注解[DateTimeFormat]、[NumberFormat]或者自定义注解
//         *
//         *
//         * 2. 由于默认一行行的读取excel，所以需要创建excel一行一行的回调监听器，参照[ConverterDataListener]
//         *
//         *
//         * 3. 直接读即可
//         */
//        @Test
//        fun converterRead() {
//            val fileName: String = TestFileUtil.getPath() + "demo" + File.separator + "demo.xlsx"
//            // 这里 需要指定读用哪个class去读，然后读取第一个sheet
//            EasyExcel.read(
//                fileName,
//                ConverterData::class.java,
//                ConverterDataListener()
//            ) // 这里注意 我们也可以registerConverter来指定自定义转换器， 但是这个转换变成全局了， 所有java为string,excel为string的都会用这个转换器。
//                // 如果就想单个字段使用请使用@ExcelProperty 指定converter
//                // .registerConverter(new CustomStringStringConverter())
//                // 读取sheet
//                .sheet().doRead()
//        }
//
//        /**
//         * 多行头
//         *
//         *
//         *
//         * 1. 创建excel对应的实体对象 参照[DemoData]
//         *
//         *
//         * 2. 由于默认一行行的读取excel，所以需要创建excel一行一行的回调监听器，参照[DemoDataListener]
//         *
//         *
//         * 3. 设置headRowNumber参数，然后读。 这里要注意headRowNumber如果不指定， 会根据你传入的class的[ExcelProperty.value]里面的表头的数量来决定行数，
//         * 如果不传入class则默认为1.当然你指定了headRowNumber不管是否传入class都是以你传入的为准。
//         */
//        @Test
//        fun complexHeaderRead() {
//            val fileName: String = TestFileUtil.getPath() + "demo" + File.separator + "demo.xlsx"
//            // 这里 需要指定读用哪个class去读，然后读取第一个sheet
//            EasyExcel.read(fileName, DemoData::class.java, DemoDataListener())
//                .sheet() // 这里可以设置1，因为头就是一行。如果多行头，可以设置其他值。不传入也可以，因为默认会根据DemoData 来解析，他没有指定头，也就是默认1行
//                .headRowNumber(1).doRead()
//        }
//
//        /**
//         * 读取表头数据
//         *
//         *
//         *
//         * 1. 创建excel对应的实体对象 参照[DemoData]
//         *
//         *
//         * 2. 由于默认一行行的读取excel，所以需要创建excel一行一行的回调监听器，参照[DemoHeadDataListener]
//         *
//         *
//         * 3. 直接读即可
//         */
//        @Test
//        fun headerRead() {
//            val fileName: String = TestFileUtil.getPath() + "demo" + File.separator + "demo.xlsx"
//            // 这里 需要指定读用哪个class去读，然后读取第一个sheet
//            EasyExcel.read(fileName, DemoData::class.java, DemoHeadDataListener()).sheet().doRead()
//        }
//
//        /**
//         * 额外信息（批注、超链接、合并单元格信息读取）
//         *
//         *
//         * 由于是流式读取，没法在读取到单元格数据的时候直接读取到额外信息，所以只能最后通知哪些单元格有哪些额外信息
//         *
//         *
//         *
//         * 1. 创建excel对应的实体对象 参照[DemoExtraData]
//         *
//         *
//         * 2. 由于默认异步读取excel，所以需要创建excel一行一行的回调监听器，参照[DemoExtraListener]
//         *
//         *
//         * 3. 直接读即可
//         *
//         * @since 2.2.0-beat1
//         */
//        @Test
//        fun extraRead() {
//            val fileName: String = TestFileUtil.getPath() + "demo" + File.separator + "extra.xlsx"
//            // 这里 需要指定读用哪个class去读，然后读取第一个sheet
//            EasyExcel.read(fileName, DemoExtraData::class.java, DemoExtraListener()) // 需要读取批注 默认不读取
//                .extraRead(CellExtraTypeEnum.COMMENT) // 需要读取超链接 默认不读取
//                .extraRead(CellExtraTypeEnum.HYPERLINK) // 需要读取合并单元格信息 默认不读取
//                .extraRead(CellExtraTypeEnum.MERGE).sheet().doRead()
//        }
//
//        /**
//         * 读取公式和单元格类型
//         *
//         *
//         *
//         * 1. 创建excel对应的实体对象 参照[CellDataReadDemoData]
//         *
//         *
//         * 2. 由于默认一行行的读取excel，所以需要创建excel一行一行的回调监听器，参照[DemoHeadDataListener]
//         *
//         *
//         * 3. 直接读即可
//         *
//         * @since 2.2.0-beat1
//         */
//        @Test
//        fun cellDataRead() {
//            val fileName: String = TestFileUtil.getPath() + "demo" + File.separator + "cellDataDemo.xlsx"
//            // 这里 需要指定读用哪个class去读，然后读取第一个sheet
//            EasyExcel.read(fileName, CellDataReadDemoData::class.java, CellDataDemoHeadDataListener()).sheet().doRead()
//        }
//
//        /**
//         * 数据转换等异常处理
//         *
//         *
//         *
//         * 1. 创建excel对应的实体对象 参照[ExceptionDemoData]
//         *
//         *
//         * 2. 由于默认一行行的读取excel，所以需要创建excel一行一行的回调监听器，参照[DemoExceptionListener]
//         *
//         *
//         * 3. 直接读即可
//         */
//        @Test
//        fun exceptionRead() {
//            val fileName: String = TestFileUtil.getPath() + "demo" + File.separator + "demo.xlsx"
//            // 这里 需要指定读用哪个class去读，然后读取第一个sheet
//            EasyExcel.read(fileName, ExceptionDemoData::class.java, DemoExceptionListener()).sheet().doRead()
//        }
//
//        /**
//         * 同步的返回，不推荐使用，如果数据量大会把数据放到内存里面
//         */
//        @Test
//        fun synchronousRead() {
//            val fileName: String = TestFileUtil.getPath() + "demo" + File.separator + "demo.xlsx"
//            // 这里 需要指定读用哪个class去读，然后读取第一个sheet 同步读取会自动finish
//            val list: List<DemoData> = EasyExcel.read(fileName).head(DemoData::class.java).sheet().doReadSync()
//            for (data in list) {
//                log.info("读取到数据:{}", JSON.toJSONString(data))
//            }
//
//            // 这里 也可以不指定class，返回一个list，然后读取第一个sheet 同步读取会自动finish
//            val listMap: List<Map<Int?, String?>> = EasyExcel.read(fileName).sheet().doReadSync()
//            for (data in listMap) {
//                // 返回每条数据的键值对 表示所在的列 和所在列的值
//                log.info("读取到数据:{}", JSON.toJSONString(data))
//            }
//        }
//
//        /**
//         * 不创建对象的读
//         */
//        @Test
//        fun noModelRead() {
//            val fileName: String = TestFileUtil.getPath() + "demo" + File.separator + "demo.xlsx"
//            // 这里 只要，然后读取第一个sheet 同步读取会自动finish
//            EasyExcel.read(fileName, NoModelDataListener()).sheet().doRead()
//        }
//    }
//
//}