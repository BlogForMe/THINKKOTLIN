import org.junit.Test
import seven.ExcelFactory
import seven.config.Config

class CT_RFID {

    @Test
    fun spmTransportation() {

        /**
         * read excel
         */
        val filePath = System.getProperty("user.dir") + "/file/CT_transportation.xlsx"
        //CreateMapLoop
        val maps = ExcelFactory.getMaps(filePath) { it: Config ->
            it.vocSize(1999)
                .title(0)
                .content(1)
                .isLoopSheet(true)
        }.CreateMapLoop()


        val stringBuilder = StringBuilder()

        val value: MutableCollection<MutableList<MutableMap<String, String>>> = maps.values
        var isClick = false
        value.forEach {
            it.forEach { eng ->
                val eventName = eng["Event Name"]
                val propertyKey = eng["Event Property Key"]
                var propertyValue = eng["Event Property Value"]

                if (propertyValue=="rfid"){
                    propertyValue  = "CT_RFID"
                }

                val line01 = " ctPushEventClick { \n"
                val line10 = " ctPushEvent(tag = \"$eventName\"){\n"
                val line2 = "it[CT_APP_MODULE] = $propertyValue \n"
                val line3 = "it[CT_PAGE_VIEW] = \"$propertyValue\" \n"
                val line4 = " it[CT_CLICK_TYPE] = CT_BUTTON \n"
                val line5 = " it[CT_CLICK_NAME] = \"$propertyValue\" \n"
                val line6 = " } \n \n"

                if (eventName == "click" && propertyKey == "appModule") {
                    isClick = true
                    stringBuilder.append(line01)
                        .append(line2)
                } else if (propertyKey == "pageView") {
                    stringBuilder.append(line3)
                    if (!isClick){ //特殊tag的情况
                        stringBuilder.append(line6)
                    }
                } else if (propertyKey == "clickType") {
                    stringBuilder.append(line4)
                } else if (isClick&&propertyKey == "clickName") {
                    stringBuilder.append(line5)
                        .append(line6)
                    isClick = false
                }else if (eventName?.isNotEmpty() == true &&eventName != "click"){
                    isClick = false
                    stringBuilder.append(line10)
                        .append(line2)
                }
            }
        }


        println(stringBuilder.toString())
    }
}