package thinkjava.Generics.Demo.AnonymousInnerClass_03;

import java.lang.reflect.Array;

/**
 * Created by Jon on 2016/6/4.
 * 15.8擦除补偿
 */
public class GenericArrayWithTypeToken<T> {
    private T[] array;

    public GenericArrayWithTypeToken(Class<T> type, int sz) {
        array = (T[]) Array.newInstance(type, sz);
    }

    public void put(int index, T item) {
        array[index] = item;
    }

    //Expose the underlying  representation:
    public T[] rep() {
        return array;
    }

    public static void main(String[] args) {
        GenericArrayWithTypeToken<Integer> gai = new GenericArrayWithTypeToken<Integer>(Integer.class, 10);
        //This now works:
        Integer[] ia = gai.rep();

//        Integer[] array = (Integer[]) new Object[10];
    }

}
