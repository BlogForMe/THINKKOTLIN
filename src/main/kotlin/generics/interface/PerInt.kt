package generics.`interface`
//1 . 泛型接口的实现类 可以指定具体的泛型接口的具体泛型类型
//2. 泛型接口的实现类，如果没有指定具体的泛型类型，必须要在这个实现类中声明一个泛型类型的占位符给接口用

interface PerInt<T> {
    fun show(name: T)
}