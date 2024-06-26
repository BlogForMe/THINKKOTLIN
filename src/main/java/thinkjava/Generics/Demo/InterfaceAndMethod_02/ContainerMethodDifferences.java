package thinkjava.Generics.Demo.InterfaceAndMethod_02;

import java.lang.reflect.Method;
import java.util.*;

/**
 * Created by Jon on 2016/6/3.
 * 15.4 泛型方法  sets.difference()
 * 获取所制定的类的方法
 */
public class ContainerMethodDifferences {
    static Set<String> methodSet(Class<?> type) {
        TreeSet<String> result = new TreeSet<>();
        for (Method m : type.getMethods())
            result.add(m.getName());
        return result;
    }

    static void interfaces(Class<?> type) {
        System.out.print("Interfaces in " + type.getSimpleName() + ": ");
        ArrayList<String> result = new ArrayList<>();
        for (Class<?> c : type.getInterfaces())
            result.add(c.getSimpleName());  //此方法返回底层类的简单名称。
        System.out.println(result);
    }

    static Set<String> object = methodSet(Objects.class);

    static {
        object.add("clone");
    }

    static void difference(Class<?> superset, Class<?> subset) {
        System.out.print(superset.getSimpleName() + " extends " + subset.getSimpleName() + ", adds :");
        Set<String> comp = Sets.difference(methodSet(superset), methodSet(subset));
        comp.removeAll(object);  // Don't show object methods
        System.out.println(comp);
        interfaces(superset);
    }

    public static void main(String[] args) {
        System.out.println("Collection: " + methodSet(Collection.class));
        interfaces(Collection.class);
        System.out.println();
        difference(Set.class, Collection.class);
        System.out.println();
        difference(HashSet.class, Set.class);
        difference(LinkedHashSet.class, Set.class);
        difference(TreeSet.class, Set.class);
        difference(List.class, Collection.class);
        difference(ArrayList.class, Collection.class);
        difference(LinkedList.class, List.class);
        difference(Queue.class, Collection.class);
        difference(PriorityQueue.class, Queue.class);
        System.out.println("Map" + methodSet(Map.class));
        difference(SortedMap.class, Map.class);
        difference(TreeMap.class, Map.class);
    }
}
