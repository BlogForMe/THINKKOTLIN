package generics;

import java.util.ArrayList;
import java.util.List;

public class TestGenerics {
    public static void main(String[] args) {
        List<String> strs = new ArrayList<String>();
//        strs.add(1);  // compile error
//        List<Object> objs = strs;  // compile error
    }
}
