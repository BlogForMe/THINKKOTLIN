import java.util.regex.Matcher
import java.util.regex.Pattern

fun main() {
//    val mutableList = mutableListOf<Person>()
//    for (i in 1..10){
//        mutableList.add(Person(i,"名称$i"))
//    }
//    val joinToString1 = mutableList.map { it.id }.joinToString()
//    println(joinToString1)
//    val split = joinToString1.split(",").map { it.trim() }
//    println(split)

//    println(mutableList.map { it.id }.joinToString { it })

//    println(mutableList.map { it.id }.joinToString())

//    val orNull = mutableList.getOrNull(11)
//    val idd = orNull?.id==3
//    if (idd)

//    val p = Pattern.compile("\\w+")
//    //创建Matcher对象
//    val m = p.matcher("abcd￥￥1234")
//    while(m.find()){
//        System.out.println(m.group());	//group(),group(0)匹配整个表达式的子字符串
//        System.out.println(m.group(0));
//    }
//    val p = Pattern.compile("[0-9]+")
//    //创建Matcher对象
//    val m: Matcher = p.matcher("1234")
//    println(m.matches())
    for(i in 1..10){
        print("abcdefghig")
    }
    println()
    println("abcdefghig".length)
    println("abcdefghigabcdefghigabcdefghigabcdefghigabcdefghigabcdefghigabcdefghigabcdefghigabcdefghigabcdefghig".length)
}

class Person(val id: Int, val name: String)