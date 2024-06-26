package thinkjava.Demo.ContainersAndList;

import thinkjava.typeinfo.pets.Pet;
import thinkjava.typeinfo.pets.Pets;

import java.util.*;

/**
 * Created by Jon on 2016/6/10.
 * 11.6 迭代器
 */
public class CrossContainerIteration {
    public static void display(Iterator<Pet> it) {
        while (it.hasNext()) {
            Pet p = it.next();
            System.out.println(p.id() + ": " + p + " ");
        }
    }

    public static void main(String[] args) {
        ArrayList<Pet> pets = Pets.arrayList(8);
        LinkedList<Pet> petsLL = new LinkedList<Pet>(pets);
        HashSet<Pet> petsHS = new HashSet<Pet>(pets);
        TreeSet<Pet> petsTS = new TreeSet<Pet>(pets);
        display(pets.iterator());
        display(petsLL.iterator());
        display(petsHS.iterator());
        display(petsTS.iterator());
    }
}
