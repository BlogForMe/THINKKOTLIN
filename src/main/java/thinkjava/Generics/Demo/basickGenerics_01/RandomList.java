package thinkjava.Generics.Demo.basickGenerics_01;


import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Jon on 2016/5/26.
 * 15.2.3  RandomList
 */
public class RandomList<T> {

    private ArrayList<T> storage = new ArrayList<>();
    private Random rand = new Random(47);

    public void add(T item) {
        storage.add(item);
    }

    public T select() {
        return storage.get(rand.nextInt(storage.size()));
    }

    public static void main(String[] args) {
        RandomList<String> rs = new RandomList<>();
        for (String s : ("The quick brown fox jumped over" + "the lazy brown dog").split(" "))
            rs.add(s);
        for (int i = 0; i < 11; i++)
            System.out.print(rs.select() + " ");
    }
}
