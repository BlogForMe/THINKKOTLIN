package generics.func


fun main() {
    val toMutableList = arrayOf(CategoryService(), CategoryService(), CategoryService()).toMutableList()
    val toMutableList1 = arrayOf(CategoryEditService(), CategoryEditService(), CategoryEditService()).toMutableList()
    swapElement(toMutableList)
    swapElement(toMutableList1)
}

inline fun <reified T> swapElement(services: MutableList<T>) {
    services?.forEach { element ->
        if (element !is CategoryEditService) {
            println("CategoryEditService")
        }else if (element !is CategoryService) {
            println("CategoryService")
        }
    }
}

