/**
 *
 * ClassName:      FontSupport
 * Description:    Description
 * Author:         zh
 * CreateDate:     2021/12/12 8:54 PM
 * UpdateUser:     zh
 * UpdateDate:     2021/12/12 8:54 PM
 * UpdateRemark:   Modify the description
 */


object FontSupport {
    val map = mutableMapOf<String, Typeface>()
    var isSystemFont = false
    val PATTERN_PUHUITI = "PuHuiTi"

    @JvmStatic
    fun fontSystemSwitch(font: Boolean) {
        isSystemFont = font
    }

    fun getTypeFace(typeFace: String): Typeface? {
        if (map.containsKey(typeFace)) {
            return map[typeFace]
        } else {
            try {
                return if (isSystemFont){
                    Typeface.DEFAULT
                }else{
                    throw Exception()
                    map[typeFace] = Typeface.PUHUITI
                    Typeface.PUHUITI
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        return return Typeface.DEFAULT
    }
}

enum class Typeface(val type:Int) {
    DEFAULT(88),PUHUITI(66)
}

fun main(){
//    println(Typeface.DEFAULT)
    FontSupport.isSystemFont =false
    println(FontSupport.getTypeFace("puhuiti")?.type)

}

