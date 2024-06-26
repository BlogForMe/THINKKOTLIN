package thinkjava.typeinfo.Demo;

import thinkjava.net.mindview.util.Print;

import java.lang.reflect.Field;

/**
 * Created by Administrator on 2017/2/7.
 */
public class ModifyingPrivateFields {
    public static void main(String[] args) throws Exception {
        WithPrivateFinalField pf = new WithPrivateFinalField();
        System.out.println(pf);

        Field f = pf.getClass().getDeclaredField("i");
        f.setAccessible(true);
        System.out.println("f.getInt(pf): " + f.getInt(pf));
        f.setInt(pf,47);
        System.out.println(pf);

        Print.print();
        f =pf.getClass().getDeclaredField("s");
        f.setAccessible(true);
        System.out.println("f.get(pf): "+f.get(pf));
        f.set(pf,"you are totally safe");
        System.out.println(pf);

        Print.print();
        f = pf.getClass().getDeclaredField("s2");
        f.setAccessible(true);
        System.out.println("f.get(pf): "+f.get(pf));
        f.set(pf,"No,you're not!");
        System.out.println(pf);
    }
}


class WithPrivateFinalField {
    private int i = 1;
    private final String s = " I'm totally safe";
    private String s2 = "Am I safe?";

    public String toString() {
        return "i = " + i + ", " + s + ", " + s2;
    }
}