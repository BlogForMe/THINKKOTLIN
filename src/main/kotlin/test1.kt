
fun main(){
    val mutableList = mutableListOf<Person>()
    for (i in 1..10){
        mutableList.add(Person(i,"名称$i"))
    }
//    val joinToString1 = mutableList.map { it.id }.joinToString()
//    println(joinToString1)
//    val split = joinToString1.split(",").map { it.trim() }
//    println(split)

//    println(mutableList.map { it.id }.joinToString { it })

//    println(mutableList.map { it.id }.joinToString())

    val orNull = mutableList.getOrNull(11)
    val idd = orNull?.id==3
    if (idd)
    println()
}

class Person(val id: Int, val name:String)