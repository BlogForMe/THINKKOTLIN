package thinkjava.Generics.Demo.Qustion_05;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by jon on 17-1-15.
 */
public class ByteSet {
    Byte[] possibles = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    Set<Byte> mySet = new HashSet<>(Arrays.asList(possibles));
    //But you can't do this:
//    Set<Byte> mySet2 = new HashSet<>(Arrays.<Byte>asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
}
