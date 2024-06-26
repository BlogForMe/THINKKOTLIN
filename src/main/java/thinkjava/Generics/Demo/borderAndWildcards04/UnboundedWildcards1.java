package thinkjava.Generics.Demo.borderAndWildcards04;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jon on 17-1-15.
 * 15.10.3无界通配符
 */
public class UnboundedWildcards1 {
    static List list1;
    static List<?> list2;
    static List<? extends Object> list3;

    static void assign1(List list) {
        list1 = list;
        list2 = list;
//        list3 = list;   //没有警告
    }

    static void assign2(List<?> list) {
        list1 = list;
        list2 = list;
        list3 = list;
    }

    static void assign3(List<? extends Object> list) {
        list1 = list;
        list2 = list;
        list3 = list;
    }

    public static void main(String[] args) {
        assign1(new ArrayList());
        assign2(new ArrayList<>());
        assign3(new ArrayList<>());//没有警告

        assign1(new ArrayList<String>());
        assign2(new ArrayList<String>());
        assign3(new ArrayList<String>());
        //Both forms are acceptable as List<?>;
        List<?> wildList = new ArrayList<>();
        wildList = new ArrayList<>();
        assign1(wildList);
        assign2(wildList);
        assign3(wildList);
    }
}
