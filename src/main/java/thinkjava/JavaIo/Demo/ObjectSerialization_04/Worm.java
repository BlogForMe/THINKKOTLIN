package thinkjava.JavaIo.Demo.ObjectSerialization_04;

import thinkjava.net.mindview.util.Print;

import java.io.*;
import java.util.Random;

/**
 * Created by Jon on 2016/5/19.
 * <p>
 * Demonstrates object serialization
 * <p>
 * 18.12对象序列化
 */
class Data implements Serializable {
    private int n;

    public Data(int n) {
        this.n = n;
    }

    @Override
    public String toString() {
        return Integer.toString(n);
    }
}


public class Worm implements Serializable {
    private static Random rand = new Random(47);
    private Data[] d = {new Data(rand.nextInt(10)), new Data(rand.nextInt(10)), new Data(rand.nextInt(10))};

    private Worm next;
    private char c;

    //Value of i == number of segments
    public Worm(int i, char x) {
        Print.print("Worm constructor: " + i);
        c = x;
        if (--i > 0)
            next = new Worm(i, (char) (x + 1));
    }

    public Worm() {
        Print.print("Default constructor");
    }

    @Override
    public String toString() {
        StringBuffer result = new StringBuffer(":");
        result.append(c);
        result.append("(");
        for (Data dat : d)
            result.append(dat);
        result.append(")");
        if (next != null)
            result.append(next);
        return result.toString();
    }


    public static void main(String[] args) throws ClassNotFoundException, IOException {
        Worm w = new Worm(6, 'a');
        Print.print("w = " + w);

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(thinkjava.JavaIo.Utils.Constants.writePathU + "worm.out"));
        out.writeObject("Worm storage\n");
        out.writeObject(w);
        out.close(); //Also flushes output
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(thinkjava.JavaIo.Utils.Constants.writePathU + "worm.out"));
        String s = (String) in.readObject();
        Worm w2 = (Worm) in.readObject();
        Print.print(s + "w2 = " + w2);


        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        ObjectOutputStream out2 = new ObjectOutputStream(bout);
        out2.writeObject("Worm storage\n");
        out2.writeObject(w);
        out2.flush();

        ObjectInputStream in2 = new ObjectInputStream(new ByteArrayInputStream(bout.toByteArray()));
        s = (String) in2.readObject();
        Worm w3 = (Worm) in2.readObject();
        Print.print(s + "w3 = " + w3);

    }
}
