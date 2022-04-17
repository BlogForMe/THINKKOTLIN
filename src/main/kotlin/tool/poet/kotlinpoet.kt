package tool.poet

import com.squareup.kotlinpoet.*


class Greeter(val name: String) {
    fun greet() {
        println("""Hello, $name""")
    }
}

fun main(vararg args: String) {
    val tacosPackage = "com.squareup.tacos"
    val source = FileSpec.get(
        tacosPackage,
        TypeSpec.classBuilder("Taco")
            .addProperty(
                PropertySpec.builder("CHEESE", String::class, KModifier.PRIVATE, KModifier.CONST)
                    .initializer("%S", "monterey jack")
                    .build()
            )
            .addProperty(
                PropertySpec.builder("sauce", String::class.asTypeName(), KModifier.PUBLIC)
                    .mutable()
                    .initializer("%S", "chipotle mayo")
                    .build()
            )
            .build()
    )
    source.writeTo(System.out)
}